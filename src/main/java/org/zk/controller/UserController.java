package org.zk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.zk.entity.User;

import java.io.File;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by zhangkang on 2018/3/6.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "/xml", produces = "application/xml")
    @ResponseBody
    public User xmlUser() {
        User user = new User();
        user.setId(100);
        return user;
    }

    @RequestMapping(value = "/json", produces = "application/json")
    @ResponseBody
    public User jsonUser() {
        User user = new User();
        user.setId(100);
        return user;
    }

    @RequestMapping("exception/{flag}")
    @ResponseBody
    public User exception(@PathVariable("flag") String flag) {
        if ("true".equals(flag)) {
            throw new RuntimeException("xxx");
        }
        User user = new User();
        user.setId(100);
        return user;
    }

    @RequestMapping("/exceptionHtml/{flag}")
    public String exceptionHtml(Model modal, @PathVariable("flag") boolean flag) {
        if (flag) {
            throw new RuntimeException("xxx");
        }
        modal.addAttribute("username", "zk");
        return "hello";
    }

    @RequestMapping("bind")
    @ResponseBody
    public User bind(@RequestBody User user) {
        User user2 = new User();
        user2.setId(100);
        user2.setUsername("zk");
        return user2;
    }

    @RequestMapping("upload")
    @ResponseBody
    public String upload(MultipartFile myFile) throws Exception{
        myFile.transferTo(new File("G:/test.txt"));
        System.out.println(myFile.getOriginalFilename());
        return "ok";
    }
}