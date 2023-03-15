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
     * @param beanName bean名称
     * @param obj 实例
     */
    public void registerBean(String beanName, Object obj);

    /**
     * 是否包含Bean
     * @param name
     * @return
     */
    public boolean containsBean(String name);
}
