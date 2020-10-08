package com.liuxiu.tools.utils;

import com.liuxiu.tools.utils.compile.JdkCompiler;

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
public class BeanFactory {

    private static BeanFactory utils;

    /**
     * @param
     * @return
     * @throws
     * @description: 制造
     * @author liuxiu
     * @date 2020-10-08 22:51
     */
    public static Class<?> make(String javasource) {

        JdkCompiler compiler = new JdkCompiler();

        Class<?> clazz = compiler.compile(javasource);

//        try {
//            System.out.println(((ITest) clazz.newInstance()).getPi());
//        } catch (InstantiationException e) {
//            ExceptionUtils.getFullStackTrace(e);
//        } catch (IllegalAccessException e) {
//            ExceptionUtils.getFullStackTrace(e);
//        }
        return clazz;
    }


}


