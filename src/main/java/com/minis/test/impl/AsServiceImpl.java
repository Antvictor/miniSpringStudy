package com.minis.test.impl;

import com.minis.test.AsService;

/**
 * @author exccedy
 * @date 2023/3/14
 **/
public class AsServiceImpl implements AsService {
    private String name;
    private Integer age;

    public AsServiceImpl(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void sayHello() {
        System.out.println("as service say Hello");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
