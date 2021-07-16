package com.ecut.controller;

import com.ecut.pojo.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/service/hello")
    public String hello() {
        System.out.println("服务提供者1-----");
        return "hello,springcloud provider01";
    }

    @RequestMapping("/service/user")
    public User user() {
        System.out.println("服务提供者1-----");

        User user = new User();
        user.setId(0);
        user.setName("张三");
        user.setPhone("00000000000");

        return user;
    }
}
