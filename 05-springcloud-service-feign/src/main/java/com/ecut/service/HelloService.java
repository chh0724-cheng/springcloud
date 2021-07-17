package com.ecut.service;

import com.ecut.fallback.MyFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 使用feign的客户端注解绑定远程提供者服务的名称
 * 名称可以大写也可以小写
 */
@FeignClient(value = "01-springcloud-service-provider",fallback = MyFallBack.class)
public interface HelloService {
    @RequestMapping("/service/hello")
    public String hello();
}
