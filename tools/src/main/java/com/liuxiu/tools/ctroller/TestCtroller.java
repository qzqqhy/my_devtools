package com.liuxiu.tools.ctroller;

import com.liuxiu.tools.DynamicCompile;
import com.liuxiu.tools.base.ITest;
import com.liuxiu.tools.utils.MyBeanFactory;
import org.apache.commons.lang.StringUtils;
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
    ITest iTest;

    @Autowired(required = false)
    MyBeanFactory myBeanFactory;

    @RequestMapping(value = "compile")
    public String test1() {

        String javasource = null;

        Thread.currentThread().getContextClassLoader();

        try {
            List<String> lines = IOUtils.readLines(Thread.currentThread()
                    .getContextClassLoader()
                    .getResourceAsStream("DynamicCompile2.txt"));
            javasource = StringUtils.join(lines, "\n");
        } catch (IOException e) {

        }

        System.out.println("javasource:" + javasource);

        MyBeanFactory.make(javasource);

        return "oktest";
    }

    @RequestMapping(value = "/t1/{name}")
    public String test(@PathVariable String name) throws IllegalAccessException, InstantiationException {

        String res = "";

        Class<ITest> aClass = ITest.getCacheMap(name);

        if (aClass != null) {
            res = aClass.newInstance().getPi();
        }

        return "ok" + name + "|" + res;
    }

    @RequestMapping(value = "/t2/{name}")
    public String test1(@PathVariable String name) throws IllegalAccessException, InstantiationException {

        String res = "";

        DynamicCompile dynamicCompile = new DynamicCompile();
        res = dynamicCompile.getPi();

        return "ok" + name + "|" + res;
    }
}
