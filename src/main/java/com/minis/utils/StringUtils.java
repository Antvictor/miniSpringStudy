package com.minis.utils;

/**
 * @author exccedy
 * @date 2023/3/18
 **/
public class StringUtils {

    public static boolean isEmpty(String data) {
        return null == data || "".equals(data.trim());
    }
}
