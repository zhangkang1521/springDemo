package org.zk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhangkang on 2018/3/6.
 */
@Controller
public class UserController {

    @RequestMapping("/hello")
    public String hello(Model modal) {
        modal.addAttribute("username", "zk");
        return "hello";
    }
}
