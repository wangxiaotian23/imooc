package com.course.imooc.server.strategy.context;

import com.course.imooc.server.dto.LoginMemberDto;
import com.course.imooc.server.dto.MemberDto;
import com.course.imooc.server.enums.LoginTypeEnum;
import com.course.imooc.server.strategy.SocialLoginStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Auther: 李清依
 * @Date: 2022/10/27 09:47
 * @Description:
 */
@Service
public class SocialLoginStrategyContext {

    @Autowired
    private Map<String, SocialLoginStrategy> socialLoginStrategyMap;

    /**
     * 执行第三方登录策略
     *
     * @param data          数据
     * @param loginTypeEnum 登录枚举类型
     * @return {@link LoginMemberDto} 用户信息
     */
    public MemberDto executeLoginStrategy(String data, LoginTypeEnum loginTypeEnum) {
        return socialLoginStrategyMap.get(loginTypeEnum.getStrategy()).login(data);
    }
}
