package com.minis.test.impl;

import com.minis.test.AsService;
import com.minis.test.BaseService;

/**
 * @author exccedy
 * @date 2023/3/14
 **/
public class AsServiceImpl implements AsService {
    private String name;
    private Integer age;
    private BaseService base;

    public AsServiceImpl(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void sayHello() {
        System.out.println("Hello, My name is : " + name + " and age is : "+ age + " and base say : ");
        base.sayHello();
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

    public BaseService getBase() {
        return base;
    }

    public void setBase(BaseService base) {
        this.base = base;
    }
}
