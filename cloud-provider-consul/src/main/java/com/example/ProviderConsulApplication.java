package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Castle
 * @Date 2021/3/30 11:28
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderConsulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderConsulApplication.class, args);
    }
}
