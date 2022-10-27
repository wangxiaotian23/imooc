package cn.bugstack.springframework;

/**
 * @Auther: 李清依
 * @Date: 2022/9/19 15:23
 * @Description:
 */
public class BeansException extends RuntimeException {
    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
