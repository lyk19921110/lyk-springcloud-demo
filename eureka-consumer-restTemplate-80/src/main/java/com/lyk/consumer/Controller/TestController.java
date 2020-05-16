package com.lyk.consumer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * 2020-5-11 消费端测试
 */
@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 提供服务应用的服务名称,restTemplate会根据配置的负载均衡算法访问服务器
     */
    private static final String applicatonName="http://LYK-SPRINGCLOUD-PROVIDER";

    @RequestMapping("/consumer/test001")
    public Map<String,Object> getTest(){
        return restTemplate.getForObject(applicatonName+"/provider/test001",Map.class);
    }


}
