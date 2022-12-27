package com.course.imooc.server.exception;

import com.course.imooc.server.enums.StatusCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import static com.course.imooc.server.enums.StatusCodeEnum.FAIL;
/**
 * @Auther: 李清依
 * @Date: 2022/10/27 19:50
 * @Description:
 */
@Getter
@AllArgsConstructor
public class BizException extends RuntimeException {

    /**
     * 错误码
     */
    private Integer code = FAIL.getCode();

    /**
     * 错误信息
     */
    private final String message;

    public BizException(String message) {
        this.message = message;
    }

    public BizException(StatusCodeEnum statusCodeEnum) {
        this.code = statusCodeEnum.getCode();
        this.message = statusCodeEnum.getDesc();
    }


}
