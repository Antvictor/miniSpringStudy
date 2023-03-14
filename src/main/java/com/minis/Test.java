package com.minis;

import com.minis.beans.BeanException;
import com.minis.context.ClassPathXmlApplicationContext;
import com.minis.test.AsService;

/**
 * @author exccedy
 * @date 2023/3/14
 **/
public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        AsService asService = null;
        try {
            asService = (AsService) context.getBean("asService");
            asService.sayHello();
        } catch (BeanException e) {
            e.printStackTrace();
        }
    }
}
