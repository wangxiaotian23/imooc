package com.course.imooc.business.controller.web;

import com.alibaba.fastjson.JSON;
import com.course.imooc.server.dto.LoginMemberDto;
import com.course.imooc.server.dto.MemberDto;
import com.course.imooc.server.dto.ResponseDto;
import com.course.imooc.server.dto.SmsDto;
import com.course.imooc.server.enums.LoginTypeEnum;
import com.course.imooc.server.enums.SmsUseEnum;
import com.course.imooc.server.exception.BusinessException;
import com.course.imooc.server.service.MemberService;
import com.course.imooc.server.service.SmsService;
import com.course.imooc.server.strategy.context.SocialLoginStrategyContext;
import com.course.imooc.server.util.UuidUtil;
import com.course.imooc.server.util.ValidatorUtil;
import com.course.imooc.server.vo.QQLoginVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: 李清依
 * @Date: 2022/10/15 21:17
 * @Description:
 */


@RestController("webMemberController")
@RequestMapping("/web/member")
public class MemberController {

    private static final Logger LOG = LoggerFactory.getLogger(MemberController.class);
    public static final String BUSINESS_NAME = "会员";

    @Autowired
    private SocialLoginStrategyContext socialLoginStrategyContext;

    @Resource
    private MemberService memberService;

    @Resource(name = "redisTemplate")
    private RedisTemplate redisTemplate;

    @Resource
    private SmsService smsService;

    /**
     * 保存，id有值时更新，无值时新增
     */
    @PostMapping("/register")
    public ResponseDto register(@RequestBody MemberDto memberDto) {
        // 保存校验
        ValidatorUtil.require(memberDto.getMobile(), "手机号");
        ValidatorUtil.length(memberDto.getMobile(), "手机号", 11, 11);
        ValidatorUtil.require(memberDto.getPassword(), "密码");
        ValidatorUtil.length(memberDto.getName(), "昵称", 1, 50);
        ValidatorUtil.length(memberDto.getPhoto(), "头像url", 1, 200);

        // 密码加密
        memberDto.setPassword(DigestUtils.md5DigestAsHex(memberDto.getPassword().getBytes()));

        // 校验短信验证码
        SmsDto smsDto = new SmsDto();
        smsDto.setMobile(memberDto.getMobile());
        smsDto.setCode(memberDto.getSmsCode());
        smsDto.setUse(SmsUseEnum.REGISTER.getCode());
        smsService.validCode(smsDto);
        LOG.info("短信验证码校验通过");

        ResponseDto responseDto = new ResponseDto();
        memberService.save(memberDto);
        responseDto.setContent(memberDto);
        return responseDto;
    }

    /**
     * 登录
     */
    @PostMapping("/login")
    public ResponseDto login(@RequestBody MemberDto memberDto) {
        LOG.info("用户登录开始");
        memberDto.setPassword(DigestUtils.md5DigestAsHex(memberDto.getPassword().getBytes()));
        ResponseDto responseDto = new ResponseDto();

        // 根据验证码token去获取缓存中的验证码，和用户输入的验证码是否一致
        String imageCode = (String) redisTemplate.opsForValue().get(memberDto.getImageCodeToken());
        LOG.info("从redis中获取到的验证码：{}", imageCode);
        if (StringUtils.isEmpty(imageCode)) {
            responseDto.setSuccess(false);
            responseDto.setMessage("验证码已过期");
            LOG.info("用户登录失败，验证码已过期");
            return responseDto;
        }
        if (!imageCode.toLowerCase().equals(memberDto.getImageCode().toLowerCase())) {
            responseDto.setSuccess(false);
            responseDto.setMessage("验证码不对");
            LOG.info("用户登录失败，验证码不对");
            return responseDto;
        } else {
            // 验证通过后，移除验证码
            redisTemplate.delete(memberDto.getImageCodeToken());
        }

        LoginMemberDto loginMemberDto = memberService.login(memberDto);
        String token = UuidUtil.getShortUuid();
        loginMemberDto.setToken(token);
        redisTemplate.opsForValue().set(token, JSON.toJSONString(loginMemberDto), 3600, TimeUnit.SECONDS);
        responseDto.setContent(loginMemberDto);
        return responseDto;
    }


    /**
     * 登录
     */
    @PostMapping("/login1")
    public ResponseDto qqLogin(@Valid @RequestBody QQLoginVO qqLoginVO) {
        ResponseDto responseDto=new ResponseDto();

        MemberDto memberDto = socialLoginStrategyContext.executeLoginStrategy(JSON.toJSONString(qqLoginVO), LoginTypeEnum.QQ);

        responseDto.setContent(memberDto);

        return responseDto;
    }
    //"https://graph.qq.com/oauth2.0/show?which=Login&display=pc&client_id=" +
    //            +this.config.QQ_APP_ID +
    //            "&response_type=token&scope=all&redirect_uri=" +
    //            this.config.QQ_REDIRECT_URI,

    //QQ_REDIRECT_URI: "https://www.talkxj.com/oauth/login/qq",

//    public ResponseDto login1(@RequestBody MemberDto memberDto) {
//
//
//    }

    /**
     * 退出登录
     */
    @GetMapping("/logout/{token}")
    public ResponseDto logout(@PathVariable String token) {
        ResponseDto responseDto = new ResponseDto();
        redisTemplate.delete(token);
        LOG.info("从redis中删除token:{}", token);
        return responseDto;
    }

    /**
     * 校验手机号是否存在
     * 存在则success=true，不存在则success=false
     */
    @GetMapping(value = "/is-mobile-exist/{mobile}")
    public ResponseDto isMobileExist(@PathVariable(value = "mobile") String mobile) throws BusinessException {
        LOG.info("查询手机号是否存在开始");
        ResponseDto responseDto = new ResponseDto();
        MemberDto memberDto = memberService.findByMobile(mobile);
        if (memberDto == null) {
            responseDto.setSuccess(false);
        } else {
            responseDto.setSuccess(true);
        }
        return responseDto;
    }

    @PostMapping("/reset-password")
    public ResponseDto resetPassword(@RequestBody MemberDto memberDto) throws BusinessException {
        LOG.info("会员密码重置开始:");
        memberDto.setPassword(DigestUtils.md5DigestAsHex(memberDto.getPassword().getBytes()));
        ResponseDto<MemberDto> responseDto = new ResponseDto();

        // 校验短信验证码
        SmsDto smsDto = new SmsDto();
        smsDto.setMobile(memberDto.getMobile());
        smsDto.setCode(memberDto.getSmsCode());
        smsDto.setUse(SmsUseEnum.FORGET.getCode());
        smsService.validCode(smsDto);
        LOG.info("短信验证码校验通过");

        // 重置密码
        memberService.resetPassword(memberDto);

        return responseDto;
    }
}
