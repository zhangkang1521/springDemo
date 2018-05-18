package org.zk;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zk.beans.Child;
import org.zk.beans.User;
import org.zk.config.ApplicationConfig;

/**
 * Created by Administrator on 8/27/2016.
 */
public class SpringTest {

    // xml配置
    @Test
    public void testXml() {
        ApplicationContext parentCtx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ConfigurableApplicationContext childCtx = new ClassPathXmlApplicationContext("child.xml");
        childCtx.setParent(parentCtx);
        childCtx.refresh();
        Child child = childCtx.getBean("child", Child.class);
        System.out.println(child);
        User user = childCtx.getBean("user", User.class);
        System.out.println(user);

//        parentCtx.getBean("child", Child.class);
        User user2 = parentCtx.getBean("user", User.class); //
        System.out.println(user2);
    }

}
