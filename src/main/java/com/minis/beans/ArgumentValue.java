package com.minis.beans;

/**
 * 对应xml的constructor
 * <constructor-arg type="int" name="level" value="3"/>
 * @author exccedy
 * @date 2023/3/15
 **/
public class ArgumentValue {
    private Object value;
    private String name;
    private String type;

    public ArgumentValue(Object value, String type) {
        this.value = value;
        this.type = type;
    }

    public ArgumentValue(Object value, String type, String name) {
        this.value = value;
        this.name = name;
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ArgumentValue{" +
                "value=" + value +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
