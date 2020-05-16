package com.eureka.provider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 服务提供者2
 */
@RestController
public class ProviderController {

    @RequestMapping("/provider/test001")
    public Map<String,Object> getTest(){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("succes","provider8002");
        return map;
    }
}
