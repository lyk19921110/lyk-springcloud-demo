package com.lyk.feign.controller;


import com.lyk.feign.feignService.TestHystrixService;
import com.lyk.feign.feignService.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 * 通过feign的方式调用微服务
 */
@RestController
@RequestMapping("/feign")
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private TestHystrixService testHystrixService;

    @RequestMapping("/test001")
    public Map<String,Object> getTest(){
        return testService.getTest();
    }

    /**
     * 该服务在eureka-provider-hystrix-8003里面,测试熔断
     * @return
     */
    @RequestMapping("/hystrix8003")
    public Map<String,Object> getHysTest(){
        return testHystrixService.getHystrixTest();
    }

}
