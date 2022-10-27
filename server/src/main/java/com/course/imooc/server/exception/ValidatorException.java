package com.course.imooc.server.exception;

/**
 * @Auther: 李清依
 * @Date: 2022/9/2 09:32
 * @Description:
 */
public class ValidatorException extends RuntimeException {
    public ValidatorException(String message) {
        super(message);
    }
}
