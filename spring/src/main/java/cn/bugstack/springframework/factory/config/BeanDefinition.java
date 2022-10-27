package cn.bugstack.springframework.factory.config;

/**
 * @Auther: 李清依
 * @Date: 2022/9/19 11:44
 * @Description:
 */
public class BeanDefinition {
    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
