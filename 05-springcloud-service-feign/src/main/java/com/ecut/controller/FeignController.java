package com.ecut.controller;

import com.ecut.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {
    @Autowired
    private HelloService helloService;
    @RequestMapping("/web/hello")
    public String hello() {
        //调用声明式的远程调用接口
       return helloService.hello();
    }
}
