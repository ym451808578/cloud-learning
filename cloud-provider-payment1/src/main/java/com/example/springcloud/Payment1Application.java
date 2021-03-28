package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 45180
 */
@EnableEurekaClient
@SpringBootApplication
public class Payment1Application {

    public static void main(String[] args) {
        SpringApplication.run(Payment1Application.class, args);
    }
}
