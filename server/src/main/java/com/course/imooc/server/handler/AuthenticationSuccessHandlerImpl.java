package com.course.imooc.server.handler;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.course.imooc.server.constant.CommonConst.APPLICATION_JSON;

/**
 * 登录成功处理
 *
 * @Auther: 李清依
 * @Date: 2022/10/29 15:15
 * @Description:
 */
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {
//    @Autowired
//    private UserAuthDao userAuthDao;
//
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException {
//        // 返回登录信息
//        UserInfoDTO userLoginDTO = BeanCopyUtils.copyObject(UserUtils.getLoginUser(), UserInfoDTO.class);
//        httpServletResponse.setContentType(APPLICATION_JSON);
//        httpServletResponse.getWriter().write(JSON.toJSONString(Result.ok(userLoginDTO)));
//        // 更新用户ip，最近登录时间
//        updateUserInfo();
    }
//
//    /**
//     * 更新用户信息
//     */
//    @Async
//    public void updateUserInfo() {
//        UserAuth userAuth = UserAuth.builder()
//                .id(UserUtils.getLoginUser().getId())
//                .ipAddress(UserUtils.getLoginUser().getIpAddress())
//                .ipSource(UserUtils.getLoginUser().getIpSource())
//                .lastLoginTime(UserUtils.getLoginUser().getLastLoginTime())
//                .build();
//        userAuthDao.updateById(userAuth);
//    }
}
