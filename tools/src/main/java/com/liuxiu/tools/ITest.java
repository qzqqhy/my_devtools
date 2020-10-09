package com.liuxiu.tools;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component("iTest")
public abstract class ITest {

    private Map<String, ITest> cacheMap = new HashMap<>();

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


    @PostConstruct
    protected void afterRun() {
        cacheMap.put(getBeanId(), this);
    }

    public ITest init(String beanId){
        return cacheMap.get(beanId);
    }
}