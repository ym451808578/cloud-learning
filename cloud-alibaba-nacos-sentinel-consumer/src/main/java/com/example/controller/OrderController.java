package com.example.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.common.entity.CommonResult;
import com.example.common.entity.Payment;
import com.example.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author 45180
 */
@RestController
public class OrderController {

    @Value("${service-url.nacos-sentinel-service}")
    private String serverUrl;

    @Resource
    private RestTemplate restTemplate;

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/consumer/payment/{id}")
    @SentinelResource(value = "getPayment", blockHandler = "blockHandler", fallback = "handlerFallBack")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常...");
        } else if (id > 4) {
            System.out.println(id);
            throw new NullPointerException("NullPointerException,空指针异常...");
        }
        return restTemplate.getForObject(serverUrl + "/payment/" + id, CommonResult.class);
    }

    public CommonResult handlerFallBack(@PathVariable("id") Long id, Throwable e) {
        Payment payment = new Payment(id, null);
        return new CommonResult(444, "fallBack异常，O(∩_∩)O哈哈~", payment);
    }

    public CommonResult blockHandler(@PathVariable("id") Long id, BlockException e) {
        Payment payment = new Payment(id, null);
        return new CommonResult(4444, "blockHandler，O(∩_∩)O哈哈~", payment);
    }

    @GetMapping("/consumer/feign/payment/{id}")
    public CommonResult getPaymentByFeign(@PathVariable("id") Long id) {
        return paymentService.getPayment(id);
    }
}
