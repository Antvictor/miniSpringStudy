package com.minis.core;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.Iterator;

/**
 * 数据源
 * @author exccedy
 * @date 2023/3/14
 **/
public class ClassPathXmlResource implements Resource{
    Document document;
    Element element;
    Iterator<Element> iterator;

    public ClassPathXmlResource(String fileName) {
        SAXReader saxReader = new SAXReader();
        URL resource = this.getClass().getClassLoader().getResource(fileName);
        try {
            this.document = saxReader.read(resource);
            this.element = document.getRootElement();
            this.iterator = this.element.elementIterator();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override
    public Object next() {
        return this.iterator.next();
    }
}
