package com.minis.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author exccedy
 * @date 2023/3/14
 **/
public class SimpleBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory{
    private Map<String, BeanDefinition> beanDefinitions = new HashMap<>();
//    private List<String> beanNames = new ArrayList<>(); name 交给SingletonBeanRegistry管理，这里删除
//    private Map<String, Object> beans = new HashMap<>(); beans 交给SingletonBeanRegistry管理，这里删除

    @Override
    public Object getBean(String beanName) throws BeanException {
        // 先查询
        Object singleton  = this.getSingleton(beanName);
        if (null == singleton) {
            // 为空再实例
            BeanDefinition definition = beanDefinitions.get(beanName);
            if (null == definition) {
                throw new BeanException("no such instance");
            }
            try {
                singleton = Class.forName(definition.getName()).newInstance();
            } catch (InstantiationException | ClassNotFoundException | IllegalAccessException e) {
                e.printStackTrace();
            }
            this.registerBean(beanName, singleton);
        }
        return singleton;
    }

    @Override
    public void registerBean(String beanName, Object obj) {
        this.registerSingleton(beanName, obj);
    }

    @Override
    public boolean containsBean(String name) {
        return false;
    }

    public void registerBeanDefinition(BeanDefinition definition) {
        this.beanDefinitions.put(definition.getId(), definition);
    }
}
