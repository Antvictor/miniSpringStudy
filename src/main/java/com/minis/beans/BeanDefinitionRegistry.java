package com.minis.beans;

/**
 * 存放BeanDefinition
 * @author exccedy
 * @date 2023/3/15
 **/
public interface BeanDefinitionRegistry {
    /**
     * 添加
     * @param name
     * @param beanDefinition
     */
    public void registerBeanDefinition(String name,BeanDefinition beanDefinition);

    /**
     * 获取
     * @param name
     * @return
     */
    public BeanDefinition getBeanDefinition(String name);

    /**
     * 删除
     * @param name
     */
    public void removeDefinition(String name);

    /**
     * 判断是否存在
     * @param name
     * @return
     */
    public boolean containsBeanDefinition(String name);
}
