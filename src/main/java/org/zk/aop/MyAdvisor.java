package org.zk.aop;

/**
 * Created by Administrator on 9/11/2016.
 */
public class MyAdvisor {

    public void beforeAdvice(){
        System.out.println("===beforeAdvice===");
    }

    public void afterAdvice() {
        System.out.println("===afterAdvice===");
    }
}
