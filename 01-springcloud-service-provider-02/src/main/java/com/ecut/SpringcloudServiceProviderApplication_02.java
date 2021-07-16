package com.ecut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringcloudServiceProviderApplication_02 {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudServiceProviderApplication_02.class, args);
    }

}
