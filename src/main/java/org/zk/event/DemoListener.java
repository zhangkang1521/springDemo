package org.zk.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 4/19/2018.
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoListener.class);

    @Override
    public void onApplicationEvent(DemoEvent event) {
        LOGGER.info("收到DemoEvent事件消息，source:{}, msg:{}", event.getSource(), event.getMsg());
    }
}
