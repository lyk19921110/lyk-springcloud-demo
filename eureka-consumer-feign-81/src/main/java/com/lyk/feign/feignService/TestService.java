package com.lyk.feign.feignService;

import com.lyk.feign.feignServiceCallBack.TestServiceCallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * 当服务不可用时，调用TestServiceCallback里重写的方法
 */
@FeignClient(value ="LYK-SPRINGCLOUD-PROVIDER",fallbackFactory = TestServiceCallback.class)
public interface TestService {

    @RequestMapping("/provider/test001")
    Map<String,Object> getTest();


}
