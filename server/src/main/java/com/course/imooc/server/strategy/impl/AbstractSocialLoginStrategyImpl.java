package com.course.imooc.server.strategy.impl;

import com.course.imooc.server.domain.Member;
import com.course.imooc.server.domain.MemberExample;
import com.course.imooc.server.dto.LoginMemberDto;
import com.course.imooc.server.dto.MemberDto;
import com.course.imooc.server.dto.SocialTokenDTO;
import com.course.imooc.server.dto.SocialUserInfoDTO;
import com.course.imooc.server.mapper.MemberMapper;
import com.course.imooc.server.service.MemberService;
import com.course.imooc.server.strategy.SocialLoginStrategy;
import com.course.imooc.server.util.CopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;

/**
 * @Auther: 李清依
 * @Date: 2022/10/27 14:25
 * @Description:
 */
@Service
public abstract class AbstractSocialLoginStrategyImpl implements SocialLoginStrategy {


    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private MemberService memberService;

    @Resource
    private HttpServletRequest request;

//    @Override
//    public UserInfoDTO login(String data) {
//        // 创建登录信息
//        UserDetailDTO userDetailDTO;
//        // 获取第三方token信息
//        SocialTokenDTO socialToken = getSocialToken(data);
//        // 获取用户ip信息
//        String ipAddress = IpUtils.getIpAddress(request);
//        String ipSource = IpUtils.getIpSource(ipAddress);
//        // 判断是否已注册
//        UserAuth user = getUserAuth(socialToken);
//        if (Objects.nonNull(user)) {
//            // 返回数据库用户信息
//            userDetailDTO = getUserDetail(user, ipAddress, ipSource);
//        } else {
//            // 获取第三方用户信息，保存到数据库返回
//            userDetailDTO = saveUserDetail(socialToken, ipAddress, ipSource);
//        }
//        // 判断账号是否禁用
//        if (userDetailDTO.getIsDisable().equals(TRUE)) {
//            throw new BizException("账号已被禁用");
//        }
//        // 将登录信息放入springSecurity管理
//        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetailDTO, null, userDetailDTO.getAuthorities());
//        SecurityContextHolder.getContext().setAuthentication(auth);
//        // 返回用户信息
//        return BeanCopyUtils.copyObject(userDetailDTO, UserInfoDTO.class);
//    }


    @Override
    public MemberDto login(String data) {

        // 获取第三方token信息
        SocialTokenDTO socialToken = getSocialToken(data);

        SocialUserInfoDTO socialUserInfo = getSocialUserInfo(socialToken);



        Member member = getMember(socialToken.getOpenId(), socialToken.getLoginType());

        if (Objects.nonNull(member)) {
            member.setLoginType(socialToken.getLoginType());
            member.setOpenid(socialToken.getOpenId());
            member.setNickname(socialUserInfo.getNickname());
            memberMapper.insert(member);
        }

        // 返回用户信息
        return CopyUtil.copy(member, MemberDto.class);
    }

    public Member getMember(String openid, Integer loginType) {
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andOpenidEqualTo(openid).andLoginTypeEqualTo(loginType);
        List<Member> members = memberMapper.selectByExample(memberExample);
        return members.get(0);
    }

    /**
     * 获取第三方token信息
     *
     * @param data 数据
     * @return {@link SocialTokenDTO} 第三方token信息
     */
    public abstract SocialTokenDTO getSocialToken(String data);


    /**
     * 获取第三方用户信息
     *
     * @param socialTokenDTO 第三方token信息
     * @return {@link SocialUserInfoDTO} 第三方用户信息
     */
    public abstract SocialUserInfoDTO getSocialUserInfo(SocialTokenDTO socialTokenDTO);
}
