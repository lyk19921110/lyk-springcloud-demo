package com.eureka.provider;


import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient//注册到eureka-server支持
@EnableCircuitBreaker//熔断支持
public class EurekaProviderHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaProviderHystrixApplication.class,args);
    }

    /**
     * 固定的死代码,对dashboard监控的支持,需要pom依赖hystrix和hystrix-dashboard和actuator
     * @return
     */
    @Bean
    public ServletRegistrationBean hystrixStreamServlet(){
        ServletRegistrationBean servletRegistrationBean=new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        servletRegistrationBean.addUrlMappings("/actuator/hystrix.stream");
        return  servletRegistrationBean;
    }
}
