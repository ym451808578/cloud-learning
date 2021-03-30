package com.example.controller;

import com.example.common.entity.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Castle
 * @Date 2021/3/30 10:34
 */
@RestController
@Slf4j
public class ProviderController {

    @Value("${server.port}")
    private String portValue;

    @GetMapping("/payment/zk")
    private String payment() {
        return "Spring Cloud With ZooKeeper, server port is " + portValue + UUID.randomUUID().toString();
    }
}
