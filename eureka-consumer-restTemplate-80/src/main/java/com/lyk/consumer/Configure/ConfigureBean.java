package com.lyk.consumer.Configure;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigureBean {

    /**
     * loadbalance采用负载均衡机制，默认为轮询
     * @return
     */
    @Bean(name ="restTempate")
    @LoadBalanced
    public RestTemplate get(){
        return new RestTemplate();
    }
}
