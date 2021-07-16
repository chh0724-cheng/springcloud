package com.ecut.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@LoadBalancerClient(name = "01-SPRINGCLOUD-SERVICE-PROVIDER", configuration = CustomerLoadBalancerConfiguration.class)
public class BeanConfig {
    @LoadBalanced //配置负载均衡
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * 覆盖掉原来ribbon默认的轮询均衡策略
     * @return
     */
//    @Bean
//    public IRule iRule() {
//        return new RandomRule();
//    }
}
