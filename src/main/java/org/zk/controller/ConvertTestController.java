package org.zk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zk.entity.DemoObj;

/**
 * Created by Administrator on 4/24/2018.
 */
@Controller
public class ConvertTestController {

    @PostMapping(value = "read", consumes = "application/demoobj", produces = "application/demoobj")
    @ResponseBody
    public DemoObj read(@RequestBody DemoObj demoObj) {
        System.out.println(demoObj);
        return demoObj;
    }
}
