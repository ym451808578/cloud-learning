package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Castle
 * @Date 2021/3/31 17:56
 */
@SpringBootApplication
@EnableFeignClients
public class ConsumerOrderOpenFeign {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderOpenFeign.class, args);
    }
}
