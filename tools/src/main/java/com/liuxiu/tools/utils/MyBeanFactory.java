package com.liuxiu.tools.utils;

import com.liuxiu.tools.utils.compile.JdkCompiler;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @version V1.0
 * @ClassName：BeanFactory
 * @Description： <p> 类制造工厂工具类 </p>
 * @Author： - liuxiu
 * @CreatTime：2020-10-08 - 22:50
 * @Modify By：
 * @ModifyTime： 2020-10-08
 * @Modify marker：
 */
@Component
public class MyBeanFactory {

    @Autowired
    private AutowireCapableBeanFactory beanFactory;

    @Autowired
    private DefaultListableBeanFactory defaultListableBeanFactory;


    /**
     * @param
     * @return
     * @throws
     * @description: 制造
     * @author liuxiu
     * @date 2020-10-08 22:51
     */
    public Object make(String javasource) throws IllegalAccessException, InstantiationException {

        JdkCompiler compiler = new JdkCompiler();

        Class<?> clazz = compiler.compile(javasource);

        //将new出的对象放入Spring容器中
        Object instance = clazz.newInstance();
        defaultListableBeanFactory.registerSingleton(StringUtils.uncapitalize(clazz.getSimpleName()), instance);

        //自动注入依赖
        beanFactory.autowireBean(instance);

        return instance;
    }


}


