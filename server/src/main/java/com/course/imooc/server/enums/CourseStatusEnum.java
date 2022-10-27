package com.course.imooc.server.enums;

/**
 * @Auther: 李清依
 * @Date: 2022/9/6 10:19
 * @Description:
 */
public enum CourseStatusEnum {


    PUBLISH("P", "发布"),
    DRAFT("D", "草稿");

    CourseStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String code;
    private String desc;
}
