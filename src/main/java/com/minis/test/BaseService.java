package com.minis.test;

/**
 * @author exccedy
 * @date 2023/3/18
 **/
public class BaseService implements AsService{
    private Base2Service base2Service;

    public Base2Service getBase2Service() {
        return base2Service;
    }

    public void setBase2Service(Base2Service base2Service) {
        this.base2Service = base2Service;
    }

    @Override
    public void sayHello() {
        System.out.println("Hello, I`m base and base2 say :");
        base2Service.sayHello();
    }
}
