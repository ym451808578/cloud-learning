package com.expample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 45180
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosPayment2Application {
    public static void main(String[] args) {
        SpringApplication.run(NacosPayment2Application.class, args);
    }

}
