package cn.bugstack.springframework.java8.first;

/**
 * @Auther: 李清依
 * @Date: 2022/12/4 21:55
 * @Description:
 */
@FunctionalInterface
public interface MyPredicate <T> {
    boolean test(T t);
}
