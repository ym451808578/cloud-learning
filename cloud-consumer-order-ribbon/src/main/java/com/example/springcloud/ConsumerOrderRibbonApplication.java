package com.example.springcloud;

import com.example.rule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author Castle
 * @Date 2021/3/31 8:18
 */
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "CLOUD-PAYMENT",configuration = MySelfRule.class) 测试自实现轮询接口，需注销
public class ConsumerOrderRibbonApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderRibbonApplication.class, args);
    }

    @Bean
        //@LoadBalanced 测试自实现轮询接口，需注销
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
