package org.zk;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zk.beans.User;
import org.zk.config.ApplicationConfig;
import org.zk.service.UserService;

/**
 * Created by Administrator on 8/27/2016.
 */
public class SpringTest {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        UserService user = ctx.getBean(UserService.class);
        System.out.println(user);
    }
}
