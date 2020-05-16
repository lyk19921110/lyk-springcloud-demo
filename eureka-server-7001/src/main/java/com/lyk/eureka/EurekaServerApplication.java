package com.lyk.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * springcloud eureka server 服务端就是注册中心相当于dubbo中的zookeeper,用于接收服务端注册
 * 启动后可通过http://localhost:7001/在浏览器访问服务注册信息页面
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class,args);
    }
}
