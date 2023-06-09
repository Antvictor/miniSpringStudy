package com.minis.beans;

import java.util.*;

/**
 * 属性的集合，提供添加、删除、查看、封装
 * @author exccedy
 * @date 2023/3/15
 **/
public class ArgumentValues {
    private final List<ArgumentValue> genericArgumentValues = new LinkedList<>();

    public ArgumentValues(){
    }
    public void addArgumentValue(ArgumentValue argumentValue) {
        this.genericArgumentValues.add(argumentValue);
    }

    public ArgumentValue getIndexedArgumentValue(int index) {
        return this.genericArgumentValues.get(index);
    }
    public void addGenericArgumentValue(Object value, String type) {
        this.genericArgumentValues.add(new ArgumentValue(value, type));
    }


    public int getArgumentCount() { return this.genericArgumentValues.size(); }
    public boolean isEmpty() { return this.genericArgumentValues.isEmpty(); }


}
