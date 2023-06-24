package org.zk.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.stereotype.Component;
import org.zk.beans.User;

/**
 * Created by Administrator on 4/19/2018.
 */
@Configuration
@ComponentScan(basePackages = "org.zk")
@EnableJms
public class ApplicationConfig {

    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL("tcp://localhost:61616");
        return connectionFactory;
    }

    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerFactory(ActiveMQConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
        containerFactory.setConnectionFactory(connectionFactory);
        return containerFactory;
    }
}
