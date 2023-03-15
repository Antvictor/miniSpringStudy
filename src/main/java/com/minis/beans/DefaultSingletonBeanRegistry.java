package com.minis.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 默认单例注册实现
 * @author exccedy
 * @date 2023/3/15
 **/
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry{
    /**
     * 所有bean的名称
      */
    protected List<String> beanNames = new ArrayList<>();
    /**
     * bean的实例
     */
    protected Map<String, Object> singletons = new ConcurrentHashMap<>(256);

    @Override
    public void registerSingleton(String beanName, Object singleton) {
            synchronized (this.singletons) {
                this.singletons.put(beanName, singleton);
                this.beanNames.add(beanName);
            }
    }

    @Override
    public Object getSingleton(String beanName) {
        return singletons.get(beanName);
    }

    @Override
    public boolean containsSingleton(String beanName) {
        return singletons.containsKey(beanName);
    }

    @Override
    public String[] getSingletonNames() {
        return (String[]) beanNames.toArray();
    }

    protected void removeSingleton(String beanName) {
        synchronized (this.singletons) {
            this.singletons.remove(beanName);
            this.beanNames.remove(beanName);
        }
    }
}
