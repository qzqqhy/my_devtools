package com.liuxiu.tools;

import com.liuxiu.tools.utils.compile.JdkCompiler;
import com.sun.deploy.util.StringUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
class ToolsApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void test() {
        String javasource = "";
        Thread.currentThread()
                .getContextClassLoader();

        try {
            List<String> lines = IOUtils.readLines(Thread.currentThread()
                    .getContextClassLoader()
                    .getResourceAsStream("DynamicCompile.java"));
            javasource = StringUtils.join(lines, "\n");
        } catch (IOException e) {

        }
//        JavaSource javaSource = new JavaSource();

        JdkCompiler compiler = new JdkCompiler();

        Class<?> clazz = compiler.compile(javasource);

        try {
            System.out.println(((ITest) clazz.newInstance()).getPi());
        } catch (InstantiationException e) {
            ExceptionUtils.getFullStackTrace(e);
        } catch (IllegalAccessException e) {
            ExceptionUtils.getFullStackTrace(e);
        }
    }

}
