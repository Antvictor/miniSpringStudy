package com.minis.beans;

import java.util.HashMap;
import java.util.Map;

/**
 * @author exccedy
 * @date 2023/3/14
 **/
public class SimpleBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory, BeanDefinitionRegistry{
    private Map<String, BeanDefinition> beanDefinitions = new HashMap<>();

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

    @Override
    public void registerBeanDefinition(String name, BeanDefinition definition) {
        this.beanDefinitions.put(name, definition);
        if (!definition.isLazyInit()) {
            try {
                getBean(name);
            } catch (BeanException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public BeanDefinition getBeanDefinition(String name) {
        return beanDefinitions.get(name);
    }

    @Override
    public void removeDefinition(String name) {
        beanDefinitions.remove(name);
    }

    @Override
    public boolean containsBeanDefinition(String name) {
        return beanDefinitions.containsKey(name);
    }

    public boolean isSingleton(String name) {
        return beanDefinitions.get(name).isSingleton();
    }
    public boolean isPrototype(String name) {
        return beanDefinitions.get(name).isPrototype();
    }
    public Class<?> getType (String name) {
        return beanDefinitions.get(name).getClass();
    }
}
