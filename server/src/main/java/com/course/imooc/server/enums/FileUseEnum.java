package com.course.imooc.server.enums;

/**
 * @Auther: 李清依
 * @Date: 2022/9/21 21:46
 * @Description:
 */
public enum FileUseEnum {
    COURSE("C", "课程"),
    TEACHER("T", "讲师");

    private String code;

    private String desc;

    FileUseEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public static FileUseEnum getByCode(String code) {
        for (FileUseEnum e : FileUseEnum.values()
        ) {
            if (e.getCode().equals(code)) {
                return e;
            }
        }
        return null;
    }
}
