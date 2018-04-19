package org.zk;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.zk.beans.User;
import org.zk.config.ApplicationConfig;

/**
 * Created by Administrator on 8/27/2016.
 */
public class SpringTest {

    // xml配置
    @Test
    public void testXml() {
        // 只会到test-classes目录下查找
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext ();
        ConfigurableEnvironment env = ctx.getEnvironment();
        env.setActiveProfiles("dev");
        ctx.load("classpath:applicationContext-*.xml");
        ctx.refresh();
        User user = ctx.getBean(User.class);
        System.out.println(user.getUsername());
    }

    // Java注解配置
    @Test
    public void testAnnotation() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ConfigurableEnvironment env = ctx.getEnvironment();
        env.setActiveProfiles("prod");
        ctx.register(ApplicationConfig.class);
        ctx.refresh();
        User user = ctx.getBean(User.class);
        System.out.println(user.getUsername());
    }

}
