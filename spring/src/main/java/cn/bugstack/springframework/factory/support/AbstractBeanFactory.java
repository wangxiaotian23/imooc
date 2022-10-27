package cn.bugstack.springframework.factory.support;

import cn.bugstack.springframework.BeansException;
import cn.bugstack.springframework.factory.BeanFactory;
import cn.bugstack.springframework.factory.config.BeanDefinition;

/**
 * @Auther: 李清依
 * @Date: 2022/9/19 15:04
 * @Description:
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) throws BeansException {
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;
}
