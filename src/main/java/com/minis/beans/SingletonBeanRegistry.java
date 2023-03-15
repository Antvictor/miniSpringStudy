package com.minis.beans;

/**
 * 单例bean注册
 * @author exccedy
 * @date 2023/3/15
 **/
public interface SingletonBeanRegistry {
    /**
     * 注册单例
     * @param beanName
     * @param singleton
     */
    void registerSingleton(String beanName, Object singleton);

    /**
     * 获取单例实例
     * @param beanName
     * @return
     */
    Object getSingleton(String beanName);

    /**
     * 是否包含
     * @param beanName
     * @return
     */
    boolean containsSingleton(String beanName);

    /**
     * 获取所有的bean名称
     * @return
     */
    String[] getSingletonNames();
}
