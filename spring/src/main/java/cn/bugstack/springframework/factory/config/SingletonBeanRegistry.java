package cn.bugstack.springframework.factory.config;

/**
 * @Auther: 李清依
 * @Date: 2022/9/19 14:51
 * @Description:
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}
