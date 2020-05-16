package com.lyk.feign.feignService;

import com.lyk.feign.feignServiceCallBack.TestHystrixServiceCallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * 当服务不可用时调用后面的TestHystrixServiceCallBack里重写的方法
 */
@FeignClient(value ="LYK-SPRINGCLOUD-HYSTRIX-PROVIDER",fallbackFactory = TestHystrixServiceCallBack.class)
public interface TestHystrixService {

    @RequestMapping("/test/hystrix")
    Map<String,Object> getHystrixTest();
}
