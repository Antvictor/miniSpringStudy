package com.minis.beans;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author exccedy
 * @date 2023/3/14
 **/
public class SimpleBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory, BeanDefinitionRegistry {
    private Map<String, BeanDefinition> beanDefinitions = new HashMap<>();

    @Override
    public Object getBean(String beanName) throws BeanException {
        // 先查询
        Object singleton = this.getSingleton(beanName);
        if (null == singleton) {
            // 为空再实例
            BeanDefinition definition = beanDefinitions.get(beanName);
            if (null == definition) {
                throw new BeanException("no such instance");
            }
//            try {
            singleton = createBean(definition);
//            } catch (InstantiationException | ClassNotFoundException | IllegalAccessException e) {
//                e.printStackTrace();
//            }
            this.registerBean(beanName, singleton);
        }
        return singleton;
    }

    private Object createBean(BeanDefinition definition) {
        Class<?> clz = null;
        Constructor<?> con = null;
        Object result = null;
        try {
            clz = Class.forName(definition.getName());
            // 获取构造方法参数
            ArgumentValues constructorArgumentValues = definition.getConstructorArgumentValues();
            // 如果有参数
            if (!constructorArgumentValues.isEmpty()) {
                int count = constructorArgumentValues.getArgumentCount();
                Class<?>[] paramTypes = new Class[count];
                Object[] paramValues = new Object[count];
                for (int i = 0; i < count; i++) {
                    ArgumentValue argumentValue = constructorArgumentValues.getIndexedArgumentValue(i);
                    String type = argumentValue.getType();
                    String value = (String) argumentValue.getValue();
                    if (Integer.class.getSimpleName().equals(type) || Integer.class.getName().equals(type)) {
                        paramTypes[i] = Integer.class;
                        paramValues[i] = Integer.valueOf(value);
                    } else if (int.class.getSimpleName().equals(type)) {
                        paramTypes[i] = int.class;
                        paramValues[i] = Integer.valueOf(value);
                    } else {
                        paramTypes[i] = String.class;
                        paramValues[i] = value;
                    }
                }
                try {
                    con = clz.getConstructor(paramTypes);
                    result = con.newInstance(paramValues);
                } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            } else {
                result = clz.newInstance();
            }

            // 处理字段
            PropertyValues propertyValues = definition.getPropertyValues();
            if (!propertyValues.isEmpty()) {
                int size = propertyValues.size();
                for (int i = 0; i < size; i++) {
                    PropertyValue propertyValue = propertyValues.getPropertyValueList().get(i);
                    String name = propertyValue.getName();
                    String type = propertyValue.getType();
                    Object value = propertyValue.getValue();
                    Class<?>[] paramTypes = new Class[1];
                    Object[] paramValues = new Object[1];
                    if (Integer.class.getSimpleName().equals(type) || Integer.class.getName().equals(type)) {
                        paramTypes[0] = Integer.class;
                        paramValues[0] = Integer.valueOf((String) value);
                    } else if (int.class.getSimpleName().equals(type)) {
                        paramTypes[0] = int.class;
                        paramValues[0] = Integer.valueOf((String) value);
                    } else {
                        paramTypes[0] = String.class;
                        paramValues[0] = value;
                    }
                    String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
                    try {
                        Method method = clz.getMethod(methodName, paramTypes);
                        method.invoke(result, paramValues);
                    } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public void registerBean(String beanName, Object obj) {
        this.registerSingleton(beanName, obj);
    }

    @Override
    public boolean containsBean(String name) {
        return false;
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition definition) {
        this.beanDefinitions.put(name, definition);
        if (!definition.isLazyInit()) {
            try {
                getBean(name);
            } catch (BeanException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public BeanDefinition getBeanDefinition(String name) {
        return beanDefinitions.get(name);
    }

    @Override
    public void removeDefinition(String name) {
        beanDefinitions.remove(name);
    }

    @Override
    public boolean containsBeanDefinition(String name) {
        return beanDefinitions.containsKey(name);
    }

    public boolean isSingleton(String name) {
        return beanDefinitions.get(name).isSingleton();
    }

    public boolean isPrototype(String name) {
        return beanDefinitions.get(name).isPrototype();
    }

    public Class<?> getType(String name) {
        return beanDefinitions.get(name).getClass();
    }

    public static void main(String[] args) {
        System.out.println(Integer.class.getName());
        System.out.println(Integer.class.getSimpleName());
        System.out.println(int.class.getSimpleName());
        System.out.println(int.class.getName());
    }
}
