package org.zk;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringTest.class);


    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        UserService userService = ctx.getBean(UserService.class);
        for (int i=0; i<10; i++) {
            // hello world是乱序的，说明是异步执行的
            userService.hello(i);
            userService.world(i);
        }
        LOGGER.info("如果是异步的，我会先打印出来");
        ctx.close();
    }

}
