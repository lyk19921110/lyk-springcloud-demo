package com.eureka.provider.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


/**
 * 用来测试hystrix服务熔断也相当于一种容错设置,
 * 一般熔断配置在服务提供方,服务降级配置在服务消费方
 * 2020-05-11
 */
@RestController
public class TestHystrixController {


    /**
     * 当外部调用该方法时，a=1/0会抛出异常，会被hystrix捕获,调用备用方法getHystrixTest
     * @return
     */
    @RequestMapping("/test/hystrix")
    @HystrixCommand(fallbackMethod ="getHystrixTest")
    Map<String,Object> getTest(){
        Map<String,Object> map=new HashMap<String,Object>();
        int a=1/0;
        return map;
    }

    //备用方法
    Map<String,Object> getHystrixTest(){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("hystrix捕获","getTest运行出错!");
        return map;
    }
}
