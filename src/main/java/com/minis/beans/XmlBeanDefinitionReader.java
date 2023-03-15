package com.minis.beans;

import com.minis.core.Resource;
import org.dom4j.Element;

/**
 * 读取数据源为Definition并注册到BeanFactory
 * @author exccedy
 * @date 2023/3/14
 **/
public class XmlBeanDefinitionReader {
    SimpleBeanFactory beanFactory;

    public XmlBeanDefinitionReader(SimpleBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    /**
     * 读取Bean
     * @param resource
     */
    public void loadDefinitions(Resource resource) {
        while (resource.hasNext()) {
            Element element = (Element) resource.next();
            String id = element.attributeValue("id");
            String className = element.attributeValue("className");
            beanFactory.registerBeanDefinition(new BeanDefinition(id, className));
        }

    }
}
