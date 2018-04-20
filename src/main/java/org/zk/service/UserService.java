package org.zk.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 4/19/2018.
 */
@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Async
    public void hello(int i) {
        LOGGER.info("hello-" + i);
    }

    @Async
    public void world(int i) {
        LOGGER.info("world-" + i);
    }
}
