package org.zk.aop.abc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 8/27/2016.
 */
public class ProxyFactoryBeanTest {

    public static void main(String[] args) throws Exception{
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object obj = ctx.getBean("testAOP");
        // 使用jdk动态代理或cglib
        MyInterface target = (MyInterface)obj;
//        MyTarget target = (MyTarget)obj;
        String str = target.sayHello("hee");
        //System.out.println(str);
    }
}
