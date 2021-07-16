package com.ecut.hystrix;

import com.netflix.hystrix.HystrixCommand;
import org.springframework.web.client.RestTemplate;

/**
 * 自定义的Hystrix请求
 */
public class MyHystrixCommand extends HystrixCommand<String> {
    public MyHystrixCommand(Setter setter, RestTemplate restTemplate) {
        super(setter);
        this.restTemplate = restTemplate;
    }

    private RestTemplate restTemplate;

    @Override
    protected String run() throws Exception {
        return restTemplate.getForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/hello", String.class).getBody();

    }

    /**
     * 当远程服务异常，超时，不可用时，会触发熔断方法
     *
     * @return
     */
    @Override
    public String getFallback() {
        Throwable throwable = super.getExecutionException();
        System.out.println(throwable.getMessage());
        System.out.println(throwable.getStackTrace());
        return "error";
    }
}
