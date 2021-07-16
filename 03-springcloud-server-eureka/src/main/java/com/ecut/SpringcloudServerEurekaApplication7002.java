package com.ecut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //开启注册中心服务
public class SpringcloudServerEurekaApplication7002 {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudServerEurekaApplication7002.class, args);
    }

}
