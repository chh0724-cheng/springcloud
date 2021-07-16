package com.ecut.controller;

import com.ecut.pojo.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/service/hello")
    public String hello() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("服务提供者2-----");
        return "hello,springcloud provider02";
    }

    @RequestMapping("/service/user")
    public User user() {
        System.out.println("服务提供者2-----");

        User user = new User();
        user.setId(0);
        user.setName("李四");
        user.setPhone("88888888888");

        return user;
    }
}
