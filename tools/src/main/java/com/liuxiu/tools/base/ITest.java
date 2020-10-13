package com.liuxiu.tools.base;

import java.util.HashMap;
import java.util.Map;

public abstract class ITest {

    protected static Map<String, Class> cacheMap = new HashMap<>();

    /**
     * @param
     * @return
     * @throws
     * @description: 执行方法
     * @author liuxiu
     * @date 2020-10-09 23:09
     */
    public abstract String getPi();

    public abstract String getBeanName();

    public abstract String getBeanId();

    public static Class getCacheMap(String key) {
        return cacheMap.get(key);
    }

    public static Map<String, Class> getMap(){
        return cacheMap;
    }

}