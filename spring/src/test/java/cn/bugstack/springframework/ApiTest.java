package cn.bugstack.springframework;

import cn.bugstack.springframework.bean.UserService;
import cn.bugstack.springframework.factory.config.BeanDefinition;
import cn.bugstack.springframework.factory.BeanFactory;
import cn.bugstack.springframework.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * @Auther: 李清依
 * @Date: 2022/9/19 14:35
 * @Description:
 */

public class ApiTest {
    @Test
    public void test_BeanFactory() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2.注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        // 3.第一次获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
        // 4.第二次获取 bean from Singleton
        UserService userService_singleton = (UserService) beanFactory.getBean("userService");
        userService_singleton.queryUserInfo();

    }


}
