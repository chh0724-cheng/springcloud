package com.ecut.controller;

import com.ecut.hystrix.MyHystrixCommand;
import com.ecut.pojo.User;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/web/hello")
    public String hello() {
        /**
         * restTemplate Get 方法
         */
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/hello", String.class);
        HttpStatus statusCode = responseEntity.getStatusCode();
        String body = responseEntity.getBody();
        HttpHeaders headers = responseEntity.getHeaders();
        int statusCodeValue = responseEntity.getStatusCodeValue();
        HashMap<String, Object> map = new HashMap<>();
        map.put("statusCode", statusCode);
        map.put("body", body);
        map.put("headers", headers);
        map.put("statusCodeValue", statusCodeValue);
        System.out.println(map);
        return restTemplate.getForObject("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/hello", String.class);
    }

    @RequestMapping("/web/user")
    public String user() {
        /**
         * restTemplate Get 方法
         */
        ResponseEntity<User> responseEntity = restTemplate.getForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/hello", User.class);
        HttpStatus statusCode = responseEntity.getStatusCode();
        User body = responseEntity.getBody();
        HttpHeaders headers = responseEntity.getHeaders();
        int statusCodeValue = responseEntity.getStatusCodeValue();
        System.out.println(statusCode);
        System.out.println(body.getId() + "--" + body.getName() + "--" + body.getPhone());
        System.out.println(headers);
        System.out.println(statusCodeValue);
        return restTemplate.getForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/hello", String.class).getBody();
    }

    /**
     * hystrix超时时间是3.5秒
     * ignoreExceptions =  RuntimeException.class 忽略异常类型，不触发熔断服务
     *
     * @return
     */
    @RequestMapping("/web/hystrix")
    @HystrixCommand(fallbackMethod = "error",/*ignoreExceptions =  RuntimeException.class,*/ commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3500")})

    public String hystrix() {
        // int a = 10/0;
        return restTemplate.getForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/hello", String.class).getBody();
    }

    public String error(Throwable throwable) {
//        System.out.println("异常" + throwable.getMessage());
        return "error";
    }

    /**
     * 使用自定义熔断服务
     *
     * @return
     */
    @RequestMapping("/web/hystrix2")
    public String hystrix2() {
        // int a = 10/0;
        MyHystrixCommand myHystrixCommand = new MyHystrixCommand(com.netflix.hystrix.HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("")), restTemplate);
        String execute = myHystrixCommand.execute();
        return execute;
    }
}
