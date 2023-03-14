package com.minis;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author exccedy
 * @date 2023/3/14
 **/
public class ClassPathXmlApplicationContext {
    private List<BeanDefinition> beanDefinitions = new ArrayList<>();
    private Map<String, Object> beans = new HashMap<>();

    ClassPathXmlApplicationContext(String fileName) {
        this.readXml(fileName);
        this.instanceBeans();
    }

    /**
     * 读取xml
     *
     * @param fileName
     */
    private void readXml(String fileName) {
        SAXReader saxReader = new SAXReader();
        URL url = this.getClass().getClassLoader().getResource(fileName);
        Document document = null;
        try {
            document = saxReader.read(url);
            // 获取根模版
            Element rootElement = document.getRootElement();
            // 遍历所有模版
            for (Element element : (List<Element>) rootElement.elements()) {
                String id = element.attributeValue("id");
                String className = element.attributeValue("className");
                // 添加到集合中
                beanDefinitions.add(new BeanDefinition(id, className));
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    private void instanceBeans() {
        for (BeanDefinition bean : beanDefinitions) {
            try {
                beans.put(bean.getId(), Class.forName(bean.getName()).newInstance());
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    public Object getBean(String beanName) {
        return beans.get(beanName);
    }
}
