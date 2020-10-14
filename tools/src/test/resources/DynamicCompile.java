package com.liuxiu.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.liuxiu.tools.base.ITest;

import javax.annotation.PostConstruct;

@Component
public class DynamicCompile3 extends ITest {

    private Integer id;

    @Autowired(required = false)
    DynamicCompile1 dynamicCompile1;

    //
    @PostConstruct
    public void init() {
        ITest.cacheMap.put("dynamicCompile3", DynamicCompile3.class);
        System.out.println("sssss: " + 1111);
    }

    @Override
    public String getPi() {
        System.out.println("dynamicCompile1:" + dynamicCompile1.getPi() + " ||| " + dynamicCompile1.getBeanName());
        return String.valueOf(Math.PI);
    }

    @Override
    public String getBeanName() {
        return "动态编译_3";
    }

    @Override
    public String getBeanId() {
        return "dynamicCompile3";
    }
}