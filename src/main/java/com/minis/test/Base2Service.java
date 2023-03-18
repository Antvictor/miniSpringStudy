package com.minis.test;

import com.minis.test.impl.AsServiceImpl;

/**
 * @author exccedy
 * @date 2023/3/18
 **/
public class Base2Service implements AsService{
    private AsService asService;
    @Override
    public void sayHello() {
        System.out.println("I`m base2");
        System.out.println(asService);
    }

    public AsService getAsService() {
        return asService;
    }

    public void setAsService(AsServiceImpl asService) {
        this.asService = asService;
    }
}
