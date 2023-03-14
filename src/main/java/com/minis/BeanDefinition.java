package com.minis;

/**
 * @author exccedy
 * @date 2023/3/14
 **/
public class BeanDefinition {
    private String id;
    private String name;

    public BeanDefinition(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
