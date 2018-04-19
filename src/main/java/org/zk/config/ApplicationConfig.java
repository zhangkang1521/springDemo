package org.zk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.zk.beans.User;

/**
 * Created by Administrator on 4/19/2018.
 */
@Configuration
public class ApplicationConfig {

    @Bean
    @Profile("dev")
    public User devUser() {
        User user = new User("dev-zk");
        return user;
    }

    @Bean
    @Profile("prod")
    public User prodUser() {
        User user = new User("prod-zk");
        return user;
    }
}
