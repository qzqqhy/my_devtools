package com.liuxiu.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.liuxiu.tools.base.ITest;

import javax.annotation.PostConstruct;


@Component
public class DynamicCompile2 extends ITest {

    private Integer id;

    @Autowired(required = false)
    DynamicCompile1 dynamicCompile1;


    @Override
    public String getPi() {
        System.out.println("dynamicCompile1:" + dynamicCompile1.getPi() + " ||| " + dynamicCompile1.getBeanName());
        return String.valueOf(Math.PI);
    }

    @Override
    public String getBeanName() {
        return "动态编译_2";
    }

    @Override
    public String getBeanId() {
        return "dynamicCompile2";
    }
}