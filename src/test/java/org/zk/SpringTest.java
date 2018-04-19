package org.zk;

import config.ApplicationConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zk.beans.User;

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
        User user = ctx.getBean(User.class);
        System.out.println(user);
    }
}
