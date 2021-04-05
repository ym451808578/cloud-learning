package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 45180
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class ConsumerHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerHystrixApplication.class, args);
    }
}
