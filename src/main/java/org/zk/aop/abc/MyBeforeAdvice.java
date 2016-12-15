package org.zk.aop.abc;

import org.aopalliance.aop.Advice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 12/13/2016.
 */
public class MyBeforeAdvice implements MethodBeforeAdvice{
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("=== before ===");
    }
}
