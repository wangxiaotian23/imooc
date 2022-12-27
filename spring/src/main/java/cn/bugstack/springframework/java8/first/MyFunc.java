package cn.bugstack.springframework.java8.first;

/**
 * @Auther: 李清依
 * @Date: 2022/12/4 22:41
 * @Description:
 */
// 函数式接口使用泛型
@FunctionalInterface
public interface MyFunc<T>{
    public Integer getValue(T t);
}
