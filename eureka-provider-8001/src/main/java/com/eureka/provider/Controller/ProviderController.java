package com.eureka.provider.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 服务提供者1
 */
@RestController
public class ProviderController {

    @RequestMapping("/provider/test001")
    public Map<String,Object> getTest() throws InterruptedException {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("succes","provider8001");
        //Thread.sleep(5000);
        return map;
    }
}
