package org.zk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.zk.beans.User;

/**
 * Created by Administrator on 4/19/2018.
 */
@Configuration
@EnableScheduling
@ComponentScan("org.zk")
public class ApplicationConfig {

    @Bean
    public User getUser() {
        User user = new User();
        user.setId(100);
        user.setUsername("zk");
        return user;
    }
}
