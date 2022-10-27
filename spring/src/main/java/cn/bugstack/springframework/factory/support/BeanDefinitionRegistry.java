package cn.bugstack.springframework.factory.support;

import cn.bugstack.springframework.factory.config.BeanDefinition;

/**
 * @Auther: 李清依
 * @Date: 2022/9/19 15:04
 * @Description:
 */
public interface BeanDefinitionRegistry {
    /**
     * 向注册表中注册 BeanDefinition
     *
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
