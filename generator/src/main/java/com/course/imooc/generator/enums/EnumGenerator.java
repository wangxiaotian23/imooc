package com.course.imooc.generator.enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: 李清依
 * @Date: 2022/8/29 21:19
 * @Description:
 */
public class EnumGenerator {
    static String path = "web\\public\\static\\js\\enums.js";

    public static void main(String[] args) {


    }


    private static void toJson(Class clazz, StringBuffer bufferObject, StringBuffer bufferArray) throws Exception {

    }


    /**
     * 功能：驼峰转大写下划线，并去掉_ENUM
     * 如：SectionChargeEnum 变成 SECTION_CHARGE
     *
     * @param str
     * @return
     */
    public static String toUnderline(String str) {
        String result = underline(str).toString();
        return result.substring(1, result.length()).toUpperCase().replace("_ENUM", "");
    }


    /**
     * 驼峰转下划线，第一位是下划线
     * 如：SectionChargeEnum 变成 _section_charge_enum
     *
     * @param str
     * @return
     */
    private static StringBuffer underline(String str) {
        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher(str);
        StringBuffer stringBuffer = new StringBuffer(str);
        if (matcher.find()) {
            stringBuffer = new StringBuffer();
            matcher.appendReplacement(stringBuffer, "_" + matcher.group(0).toLowerCase());
            matcher.appendTail(stringBuffer);
        } else {
            return stringBuffer;
        }
        return underline(stringBuffer.toString());

    }
}
