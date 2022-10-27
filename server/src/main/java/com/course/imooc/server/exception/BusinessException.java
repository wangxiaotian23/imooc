package com.course.imooc.server.exception;

/**
 * @Auther: 李清依
 * @Date: 2022/8/30 09:34
 * @Description:
 */
public class BusinessException extends RuntimeException{
    private BusinessExceptionCode code;

    public BusinessException (BusinessExceptionCode code) {
        super(code.getDesc());
        this.code = code;
    }

    public BusinessExceptionCode getCode() {
        return code;
    }

    public void setCode(BusinessExceptionCode code) {
        this.code = code;
    }

    /**
     * 不写入堆栈信息，提高性能
     */
    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
