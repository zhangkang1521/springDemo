package org.zk.jms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;

/**
 * @author zhangkang
 * @date 2023/6/24 20:56
 */
@Component
@Slf4j
public class MyMessageListener2 {

    @JmsListener(destination = "demo-queue")
    public void onMessage(Message message) {
        log.info("收到消息：{}", message);
    }
}
