package com.liuxiu.tools.ctroller;

import com.liuxiu.tools.ITest;
import com.liuxiu.tools.utils.MyBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/testc")
public class TestCtroller {

    @Autowired(required = false)
    ITest iTest;

    @Autowired(required = false)
    MyBeanFactory myBeanFactory;

    @RequestMapping(value = "compile")
    public String test1() {

        MyBeanFactory.make("package com.liuxiu.tools;public class DynamicCompile1 { public String getPi() {return String.valueOf(Math.PI);} }");

        return "oktest";
    }

    @RequestMapping(value = "/t1/{name}")
    public String test(@PathVariable String name) {

        String res = "";

        ITest init = iTest.init(name);

        if (init != null) {
            res = init.getPi() + init.getBeanName();
        }

        return "ok" + name + "|" + res;
    }
}
