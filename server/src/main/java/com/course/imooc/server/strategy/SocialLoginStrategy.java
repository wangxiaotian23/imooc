package com.course.imooc.server.strategy;

import com.course.imooc.server.dto.LoginMemberDto;
import com.course.imooc.server.dto.MemberDto;

/**
 * @Auther: 李清依
 * @Date: 2022/10/27 09:44
 * @Description:
 */

public interface SocialLoginStrategy {

    /**
     * 登录
     *
     * @param data 数据
     * @return {@link LoginMemberDto} 用户信息
     */
    MemberDto login(String data);
}
