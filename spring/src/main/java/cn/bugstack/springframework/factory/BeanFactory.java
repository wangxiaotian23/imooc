package cn.bugstack.springframework.factory;

import cn.bugstack.springframework.BeansException;
import cn.bugstack.springframework.factory.config.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: 李清依
 * @Date: 2022/9/19 12:42
 * @Description:
 */
public interface BeanFactory {
    Object getBean(String name) throws BeansException;
}
