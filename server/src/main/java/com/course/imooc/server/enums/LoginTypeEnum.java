package com.course.imooc.server.enums;

/**
 * @Auther: 李清依
 * @Date: 2022/10/27 14:21
 * @Description:
 */
public enum LoginTypeEnum {
    /**
     * 邮箱登录
     */
    EMAIL(1, "邮箱登录", ""),
    /**
     * QQ登录
     */
    QQ(2, "QQ登录", "qqLoginStrategyImpl"),
    /**
     * 微博登录
     */
    WEIBO(3, "微博登录", "weiboLoginStrategyImpl");

    /**
     * 登录方式
     */
    private final Integer type;

    /**
     * 描述
     */
    private final String desc;

    /**
     * 策略
     */
    private final String strategy;

    LoginTypeEnum(Integer type, String desc, String strategy) {
        this.type = type;
        this.desc = desc;
        this.strategy = strategy;
    }

    public Integer getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public String getStrategy() {
        return strategy;
    }
}
