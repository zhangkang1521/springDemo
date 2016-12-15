package org.zk.aop.abc;

import org.springframework.aop.ThrowsAdvice;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 12/15/2016.
 */
public class MyThrowAdvice implements ThrowsAdvice {

    // 只用最后一个afterThrowing，所以这个方法不会被回调
    public void afterThrowing(Exception ex){
        System.out.println("callback afterThrowing(Exception ex)");
    }

    public void afterThrowing(Method method, Object[] args, Object target, Exception ex){
        System.out.println("callback afterThrowing(Method method, Object[] args, Object target, Exception ex)");
        // 此处抛出异常会覆盖掉原来方法的异常
        //throw new RuntimeException("hide?");
    }


}
