package org.zk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.zk.beans.User;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 4/19/2018.
 */
@Configuration
@EnableAsync
@ComponentScan("org.zk")
public class ApplicationConfig extends AsyncConfigurerSupport {

    public Executor getAsyncExecutor() {
//        ExecutorService executor = Executors.newFixedThreadPool(3);
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(3);
        executor.setMaxPoolSize(5);
        executor.setQueueCapacity(1000);
        executor.initialize();
        return executor;
    }

    @Bean
    public User getUser() {
        User user = new User();
        user.setId(100);
        user.setUsername("zk");
        return user;
    }
}
