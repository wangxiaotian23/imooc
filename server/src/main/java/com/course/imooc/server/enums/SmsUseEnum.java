package com.course.imooc.server.enums;

/**
 * @Auther: 李清依
 * @Date: 2022/8/30 21:01
 * @Description:
 */
public enum SmsUseEnum {
    REGISTER("R", "注册"),
    FORGET("F", "忘记密码");


    SmsUseEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private String code;
    private String desc;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
