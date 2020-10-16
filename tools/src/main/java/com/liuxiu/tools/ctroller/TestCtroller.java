package com.liuxiu.tools.ctroller;

import com.alibaba.fastjson.JSONObject;
import com.liuxiu.tools.base.ITest;
import com.liuxiu.tools.utils.MyBeanFactory;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.util.List;

@RestController("/testc")
public class TestCtroller {


    @Autowired(required = false)
    MyBeanFactory myBeanFactory;

    @Autowired(required = false)
    BeanFactory beanFactory;

    @RequestMapping(value = "compile")
    public String test1() throws InstantiationException, IllegalAccessException {

        String javasource = null;

//        Thread.currentThread().getContextClassLoader();

//        System.out.println("classLoader:Thread.currentThread().getContextClassLoader():" + JSONObject.toJSONString(Thread.currentThread().getContextClassLoader()));
//        System.out.println("classLoader:this:" + JSONObject.toJSONString(this.getClass().getClassLoader()));
//        System.out.println("classLoader:myBeanFactory:" + JSONObject.toJSONString(myBeanFactory.getClass().getClassLoader()));

        try {
            List<String> lines = IOUtils.readLines(Thread.currentThread()
                    .getContextClassLoader()
                    .getResourceAsStream("DynamicCompile2.java"));
            javasource = StringUtils.join(lines, "\n");
        } catch (IOException e) {

        }

        System.out.println("javasource:" + javasource);

        myBeanFactory.make(javasource);

        return "oktest";
    }

    @RequestMapping(value = "/t1/{name}")
    public String test(@PathVariable String name) throws IllegalAccessException, InstantiationException {

        String res = "";


        try {
            ITest iTest = beanFactory.getBean(name, ITest.class);
            if (iTest != null) {
                res = iTest.getPi();
            }
        } catch (Exception e) {
            res = e.getMessage();
        }

        return "ok" + name + "|" + res;
    }

    @RequestMapping(value = "/t2/{name}")
    public String test1(@PathVariable String name) throws IllegalAccessException, InstantiationException {

        String res = "";


        return "ok" + name + "|" + res;
    }
}
