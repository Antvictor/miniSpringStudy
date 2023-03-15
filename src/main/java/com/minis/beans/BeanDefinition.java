package com.minis.beans;

/**
 * @author exccedy
 * @date 2023/3/14
 **/
public class BeanDefinition {
    private String SCOPE_SINGLETON = "singleton";
    private String SCOPE_PROTOTYPE = "prototype";
    /**
     * 是否加载是初始化
     */
    private boolean lazyInit = false;
    /**
     * 初始化的方法名
     */
    private String initMethodName;
    /**
     * 依赖关系
     */
    private String[] dependsOn;

    private volatile Object beanClass;
    private String id;
    private String name;
    private ArgumentValues constructorArgumentValues;
    private PropertyValues propertyValues;

    /**
     * 使用什么模式
     */
    private String scope = SCOPE_SINGLETON;

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


    public boolean isLazyInit() {
        return lazyInit;
    }

    public void setLazyInit(boolean lazyInit) {
        this.lazyInit = lazyInit;
    }

    public String getInitMethodName() {
        return initMethodName;
    }

    public void setInitMethodName(String initMethodName) {
        this.initMethodName = initMethodName;
    }

    public String[] getDependsOn() {
        return dependsOn;
    }

    public void setDependsOn(String[] dependsOn) {
        this.dependsOn = dependsOn;
    }

    public Object getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Object beanClass) {
        this.beanClass = beanClass;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArgumentValues getConstructorArgumentValues() {
        return constructorArgumentValues;
    }

    public void setConstructorArgumentValues(ArgumentValues constructorArgumentValues) {
        this.constructorArgumentValues = constructorArgumentValues;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public String getScope() {
        return scope;
    }

    public boolean isSingleton() {
        return SCOPE_SINGLETON.equals(scope);
    }

    public boolean isPrototype() {
        return SCOPE_PROTOTYPE.equals(scope);
    }
}
