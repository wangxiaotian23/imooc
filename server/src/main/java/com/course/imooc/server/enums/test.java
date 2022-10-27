package com.course.imooc.server.enums;

/**
 * @Auther: 李清依
 * @Date: 2022/10/16 15:27
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        SmsUseEnum[] values = SmsUseEnum.values();
        int i = 1;
        String code = String.valueOf((int)(((Math.random() * 9) + 1) * 100000));
        System.out.println((int)(((Math.random() * 9) + 1)));
        System.out.println(code);
    }
}
