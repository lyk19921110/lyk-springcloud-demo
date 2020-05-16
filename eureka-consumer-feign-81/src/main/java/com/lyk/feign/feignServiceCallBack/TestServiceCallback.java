package com.lyk.feign.feignServiceCallBack;

import com.lyk.feign.feignService.TestService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 用于TestService接口的服务降级时的操作
 * 当TestService调用的远程服务关闭或不可用时，执行下面的副本方法返回给用户
 * 服务降级在客户端(consumer)设置，服务熔断在服务端(provider)设置
 */
@Component
public class TestServiceCallback implements FallbackFactory {
    @Override
    public Object create(Throwable throwable) {
        return new TestService() {
            @Override
            public Map<String, Object> getTest() {
                Map<String,Object> map=new HashMap<String,Object>();
                map.put("HYSTRIX!","你访问的服务正在维护中!--TestServiceCallback");
                return map;
            }
        };
    }
}
