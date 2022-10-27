package cn.bugstack.springframework.factory.support;

import cn.bugstack.springframework.BeansException;
import cn.bugstack.springframework.factory.config.BeanDefinition;

/**
 * @Auther: 李清依
 * @Date: 2022/9/19 15:04
 * @Description:
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {


    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {

            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName, beanDefinition);
        return bean;
    }
}
