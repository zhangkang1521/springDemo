package org.zk.aop.abc;

/**
 * Created by Administrator on 12/13/2016.
 */
public class MyTarget implements MyInterface {
    public String sayHello(String str) {
        System.out.println("hello");
        if("xx".equals(str)) {
            throw new RuntimeException("xx");
        }
        return "hello,"+str;
    }
}
