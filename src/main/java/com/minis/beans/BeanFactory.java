package com.minis.beans;

/**
 * @author exccedy
 * @date 2023/3/14
 **/
public interface BeanFactory {
    /**
     * 获取Bean
     * @param beanName 实例名称
     * @return
     */
    public Object getBean(String beanName) throws BeanException;

    /**
     * 注册实例
     * @param definition
     */
    public void registerBeanDefinition(BeanDefinition definition);
}
