package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Castle
 * @Date 2021/4/8 11:11
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NacosConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigApplication.class, args);
    }

    @RestController
    @RefreshScope
    public class ConfigController {

        @Value("${config.info}")
        private String configInfo;

        @GetMapping("/config/info")
        public String getConfigInfo() {
            return configInfo;
        }

    }
}
