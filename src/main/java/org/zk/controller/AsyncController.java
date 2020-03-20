package org.zk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;
import org.zk.service.PushService;

/**
 * Created by Administrator on 4/24/2018.
 */
@Controller
public class AsyncController {

//    @Autowired
//    PushService pushService;


//    @RequestMapping("/defer")
//    @ResponseBody
//    public DeferredResult<String> defer() {
//        return pushService.getDeferredResult();
//    }
//
//    @RequestMapping("update")
//    @ResponseBody
//    public String update() {
//        pushService.update();
//        return "ok";
//    }
}
