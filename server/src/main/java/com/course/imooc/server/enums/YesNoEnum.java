package com.course.imooc.server.enums;

/**
 * @Auther: 李清依
 * @Date: 2022/8/30 20:59
 * @Description:
 */
public enum YesNoEnum {
    YES("1","是"),
    NO("0","否");

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

    YesNoEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
