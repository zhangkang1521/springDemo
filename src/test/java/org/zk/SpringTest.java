package org.zk;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.zk.beans.User;
import org.zk.config.ApplicationConfig;

import javax.jms.*;

/**
 * Created by Administrator on 8/27/2016.
 */
public class SpringTest {

    @Test
    public void testSend() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        JmsTemplate jmsTemplate = ctx.getBean("jmsTemplate", JmsTemplate.class);
        Destination destination = ctx.getBean("destination", Destination.class);
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("hello,world");
            }
        });
    }

    @Test
    public void testReceive() throws Exception{
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        JmsTemplate jmsTemplate = ctx.getBean("jmsTemplate", JmsTemplate.class);
        Destination destination = ctx.getBean("destination", Destination.class);
        TextMessage textMessage = (TextMessage) jmsTemplate.receive(destination);
        System.out.println(textMessage.getText());
    }


}
