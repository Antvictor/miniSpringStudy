package com.minis.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author exccedy
 * @date 2023/3/14
 **/
public class SimpleBeanFactory implements BeanFactory{
    private List<BeanDefinition> beanDefinitions = new ArrayList<>();
    private List<String> beanNames = new ArrayList<>();
    private Map<String, Object> beans = new HashMap<>();

    @Override
    public Object getBean(String beanName) throws BeanException {
        // 先查询
        Object o  = beans.get(beanName);
        if (null == o) {
            // 为空再实例
            int index = beanNames.indexOf(beanName);
            if (-1 == index) {
                throw new BeanException("no such instance");
            }
            BeanDefinition beanDefinition = beanDefinitions.get(index);
            try {
                o = Class.forName(beanDefinition.getName()).newInstance();
            } catch (InstantiationException | ClassNotFoundException | IllegalAccessException e) {
                e.printStackTrace();
            }
            beans.put(beanName, o);
        }
        return o;
    }

    @Override
    public void registerBeanDefinition(BeanDefinition definition) {
        this.beanDefinitions.add(definition);
        this.beanNames.add(definition.getId());
    }
}
