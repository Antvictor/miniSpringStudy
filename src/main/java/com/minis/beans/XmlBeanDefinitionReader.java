package com.minis.beans;

import com.minis.core.Resource;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.List;

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
            BeanDefinition beanDefinition = new BeanDefinition(id, className);
            // 获取属性
            List<Element> properties = element.elements("property");
            PropertyValues pvs = new PropertyValues();
            for (Element e : properties) {
                String name = e.attributeValue("name");
                String type = e.attributeValue("type");
                String value = e.attributeValue("value");
                pvs.addPropertyValue(new PropertyValue(name, type, value));
            }
            beanDefinition.setPropertyValues(pvs);

            // 获取构造方法参数
            List<Element> constructorArg = element.elements("constructor-arg");
            ArgumentValues avs = new ArgumentValues();
            for (Element e : constructorArg) {
                String name = e.attributeValue("name");
                String type = e.attributeValue("type");
                String value = e.attributeValue("value");
                avs.addArgumentValue(new ArgumentValue(value, type, name));
            }
            beanDefinition.setConstructorArgumentValues(avs);

            this.beanFactory.registerBeanDefinition(id, beanDefinition);
        }

    }
}
