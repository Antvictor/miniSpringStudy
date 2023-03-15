package com.minis.beans;

import java.util.*;

/**
 * 属性的集合，提供添加、删除、查看、封装
 * @author exccedy
 * @date 2023/3/15
 **/
public class ArgumentValues {
    private final Map<Integer, ArgumentValue> indexArgumentValues = new HashMap<>();
    private final List<ArgumentValue> genericArgumentValues = new LinkedList<>();

    public ArgumentValues(){
    }
    private void addIndexArgumentValue(Integer key, ArgumentValue argumentValue) {
        this.indexArgumentValues.put(key, argumentValue);
    }
    public boolean hasIndexedArgumentValue(int index){
        return this.indexArgumentValues.containsKey(index);
    }
    public ArgumentValue getIndexedArgumentValue(int index) {
        return this.indexArgumentValues.get(index);
    }
    public void addGenericArgumentValue(Object value, String type) {
        this.genericArgumentValues.add(new ArgumentValue(value, type));
    }
    public void addGenericArgumentValue(ArgumentValue newValue) {
        if (null != newValue.getName()) {
            // 循环判断是否有相同的名称，有就删除原来的值
            this.genericArgumentValues.removeIf(currentValue -> currentValue.getName().equals(newValue.getName()));
        }
        this.genericArgumentValues.add(newValue);
    }
    public ArgumentValue getGenericArgumentValue(String requiredName) {
        for (ArgumentValue value: genericArgumentValues) {
            if (value.getValue() != null &&(null == requiredName || !requiredName.equals(value.getName()))) {
                continue;
            }
            return value;
        }
        return null;
    }

    public int getArgumentCount() { return this.genericArgumentValues.size(); }
    public boolean isEmpty() { return this.genericArgumentValues.isEmpty(); }
}
