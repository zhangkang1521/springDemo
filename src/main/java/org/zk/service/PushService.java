package org.zk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Date;

/**
 * Created by Administrator on 4/24/2018.
 */
@Service
public class PushService {

    public DeferredResult<String> deferredResult;

    public DeferredResult<String> getDeferredResult() {
        deferredResult = new DeferredResult<>();
        return deferredResult;
    }

    public void update() {
        if (deferredResult != null) {
            deferredResult.setResult(new Date().toString());
        }
    }
}
