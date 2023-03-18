package com.minis.beans;

/**
 * set属性值
 *  <property type="String" name="property2" value="Hello World!"/>
 * @author exccedy
 * @date 2023/3/15
 **/
public class PropertyValue {
    private String name;
    private String type;
    private Object value;
    private boolean ref;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public PropertyValue(String name, String type, Object value) {
        this.name = name;
        this.type = type;
        this.value = value;
    }

    public PropertyValue(String name, String type, Object value, boolean ref) {
        this.name = name;
        this.type = type;
        this.value = value;
        this.ref = ref;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public boolean isRef() {
        return ref;
    }

    public void setRef(boolean ref) {
        this.ref = ref;
    }
}
