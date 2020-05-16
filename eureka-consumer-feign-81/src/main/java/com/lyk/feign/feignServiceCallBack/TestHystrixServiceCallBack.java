package com.lyk.feign.feignServiceCallBack;

import com.lyk.feign.feignService.TestHystrixService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 服务降级当TestHystrixService调用的服务不可用时触发
 * 和服务熔断最大的区别是一个在Consumer设置,一个在provider设置
 */
@Component
public class TestHystrixServiceCallBack implements FallbackFactory {
    @Override
    public Object create(Throwable throwable) {
        return new TestHystrixService() {
            @Override
            public Map<String, Object> getHystrixTest() {
                Map<String,Object> map=new HashMap<String,Object>();
                map.put("HYSTRIX!","你访问的服务正在维护中!--TestHystrixServiceCallBack");
                return map;
            }
        };
    }
}
