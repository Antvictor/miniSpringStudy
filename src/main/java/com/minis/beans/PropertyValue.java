package com.minis.beans;

/**
 * set属性值
 *  <property type="String" name="property2" value="Hello World!"/>
 * @author exccedy
 * @date 2023/3/15
 **/
public class PropertyValue {
    private String name;
    private Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
