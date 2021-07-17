package com.ecut.fallback;

import com.ecut.service.HelloService;
import org.springframework.stereotype.Component;

@Component
public class MyFallBack implements HelloService {
    @Override
    public String hello() {
        return "远程服务不可用，暂时使用本地逻辑代替";
    }
}
