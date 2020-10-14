package com.liuxiu.tools;

import com.liuxiu.tools.base.ITest;
import com.liuxiu.tools.utils.MyBeanFactory;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@SpringBootTest
class ToolsApplicationTests {

    @Test
    void contextLoads() {
    }


    @Autowired(required = false)
    MyBeanFactory myBeanFactory;


    @Test
    public void test() throws IllegalAccessException, InstantiationException {
        String javasource = null;//"package com.liuxiu.tools;public class DynamicCompile1 { public String getPi() {return String.valueOf(Math.PI);} }";
        Thread.currentThread().getContextClassLoader();

        try {
            List<String> lines = IOUtils.readLines(Thread.currentThread()
                    .getContextClassLoader()
                    .getResourceAsStream("DynamicCompile.java"));
            javasource = StringUtils.join(lines, "\n");
        } catch (IOException e) {

        }

        System.out.println("javasource:" + javasource);


        Object o = myBeanFactory.make(javasource);
        ITest tt = ((ITest)o);
        System.out.println(tt.getPi());

        Map<String, Class> map = ITest.getMap();
        ITest ss = ((ITest)ITest.getCacheMap("dynamicCompile3").newInstance());;
        System.out.println(ss.getPi() + ss.getBeanId() + ss.getBeanName());

    }

}
