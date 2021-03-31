package com.example.springcloud.controller;

import com.example.common.entity.CommonResult;
import com.example.common.entity.Payment;
import com.example.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author Castle
 * @Date 2021/3/31 8:30
 */
@RestController
@Slf4j
public class ConsumerOrderController {

    @Resource
    private RestTemplate restTemplate;

    /**
     * 引入自实现的轮询接口
     */
    @Resource
    private LoadBalancer loadBalancer;

    /**
     * 用于获取服务信息
     */
    @Resource
    private DiscoveryClient discoveryClient;

    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT";

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }


    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB() {
        //返回服务器列表
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT");
        log.info(instances.toString());
        if (instances == null || instances.size() <= 0) {
            log.info("无服务实例");
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        log.info("==========URI :" + uri);
        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }
}
