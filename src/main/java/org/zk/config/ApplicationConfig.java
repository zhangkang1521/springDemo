package org.zk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.zk.beans.User;

/**
 * Created by Administrator on 4/19/2018.
 */
@Configuration
public class ApplicationConfig {

    @Bean
    @Conditional(WindowsCondition.class)
    public User windowsUser() {
        User user = new User();
        user.setId(100);
        user.setUsername("windows-zk");
        return user;
    }

    @Bean
    @Conditional(LinuxCondition.class)
    public User linuxUser() {
        User user = new User();
        user.setId(100);
        user.setUsername("linux-zk");
        return user;
    }
}
