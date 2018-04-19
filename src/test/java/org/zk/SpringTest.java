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

    // xml配置
    @Test
    public void testXml() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User)ctx.getBean("user");
        System.out.println(user);
    }

    // Java注解配置
    @Test
    public void testAnnotation() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        UserService userService = ctx.getBean(UserService.class);
        userService.readProperties();
    }
}
