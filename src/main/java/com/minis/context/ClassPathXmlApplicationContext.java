package com.minis.context;

import com.minis.beans.*;
import com.minis.core.ClassPathXmlResource;
import com.minis.core.Resource;

/**
 * @author exccedy
 * @date 2023/3/14
 **/
public class ClassPathXmlApplicationContext implements BeanFactory {
    BeanFactory beanFactory;

    public ClassPathXmlApplicationContext(String fileName) {
        this(fileName, true);
    }

    /**
     * context 整合类注册的整个过程。读取外部配置，解析Bean定义，创建BeanFactory
     * @param fileName
     */
    public  ClassPathXmlApplicationContext(String fileName, boolean isRefresh) {
        Resource resource = new ClassPathXmlResource(fileName);
        SimpleBeanFactory beanFactory = new SimpleBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadDefinitions(resource);
        this.beanFactory = beanFactory;
        if (isRefresh) {
            beanFactory.refresh();
        }
    }

    @Override
    public Object getBean(String beanName) throws BeanException {
        return this.beanFactory.getBean(beanName);
    }

    @Override
    public void registerBean(String beanName, Object obj) {
        this.beanFactory.registerBean(beanName, obj);
    }

    @Override
    public boolean containsBean(String name) {
        return false;
    }
}
