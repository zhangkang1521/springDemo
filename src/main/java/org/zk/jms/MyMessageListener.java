package org.zk.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by zhangkang on 2019/3/9.
 */
public class MyMessageListener implements MessageListener {

    Logger log = LoggerFactory.getLogger(MyMessageListener.class);

    @Override
    public void onMessage(Message message) {
        try {
            log.info(((TextMessage)message).getText());
            Thread.sleep(3000);
            log.info("end");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
