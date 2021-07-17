package com.ecut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//开启feign支持
@EnableFeignClients
public class SpringCloudServiceFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudServiceFeignApplication.class, args);
    }

}
