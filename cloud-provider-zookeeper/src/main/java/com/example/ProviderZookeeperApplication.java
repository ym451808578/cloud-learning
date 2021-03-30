package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Castle
 * @Date 2021/3/30 10:32
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderZookeeperApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderZookeeperApplication.class, args);
    }
}
