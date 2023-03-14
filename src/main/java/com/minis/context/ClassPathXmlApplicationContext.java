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

    /**
     * context 整合类注册的整个过程。读取外部配置，解析Bean定义，创建BeanFactory
     * @param fileName
     */
    public  ClassPathXmlApplicationContext(String fileName) {
        Resource resource = new ClassPathXmlResource(fileName);
        BeanFactory beanFactory = new SimpleBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadDefinitions(resource);
        this.beanFactory = beanFactory;
    }

    @Override
    public Object getBean(String beanName) throws BeanException {
        return this.beanFactory.getBean(beanName);
    }

    @Override
    public void registerBeanDefinition(BeanDefinition definition) {
        this.beanFactory.registerBeanDefinition(definition);
    }
}
