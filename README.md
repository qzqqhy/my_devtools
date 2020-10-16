# my_devtools v1

就目前市面上可以直接手撸java代码的并不是很多，规则引擎填补了 可以代替大量判断 业务更新频繁的那块代码，把其摘了出去。 如：EasyRules、Drools
EasyRules，可以参考我的另一个git项目：https://github.com/qzqqhy/EasyRulesDemo
 这个项目实现了把规则写到数据库里，来进行规则的配置；

而直接上线整个java文件的，就目前发现有：CGLIB、Javassist、ASM 对于这些入门有些高，学习成本比较大的，且Javassist不支持jdk1.8 ，这个开源的 工具就产生了，直接手撸java代码，就能实现动态代理的那些功能。 直接下载去看看吧...

支持Spring注入 
````
//var1 Java代码 需要包涵 报名全路径等
MyBeanFactory.make(String var1);  

内附单元测试：ToolsApplicationTests.test();

和TestCtroller.compile

已完成测试：
1、http://localhost:8081/compile 编译资源文件下的java文件
2、http://localhost:8081/t1/dynamicCompile2 运行编译后的返回结果

````


注：代码非全部原创，引用了：https://github.com/alibaba/yugong.git 开源项目的部分源码，进行并进行了修改，才达成了 目前的效果
感谢愚公老师的开源项目。