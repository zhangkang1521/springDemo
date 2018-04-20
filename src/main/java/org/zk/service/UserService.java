package org.zk.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Administrator on 4/20/2018.
 */
@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

//    @Scheduled(fixedRate = 1000)
    @Scheduled(cron = "*/2 * * * * ?")
    public void test1() {
        LOGGER.info("test1: {}", new Date());
    }
}
