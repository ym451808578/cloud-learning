package com.example.service;

import com.example.common.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Castle
 * @Date 2021/4/1 8:04
 */
@Component
@FeignClient("CLOUD-PAYMENT")
public interface PaymentFeignService {

    /**
     * 根据id获取支付信息
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/get/{id}")
    CommonResult getPaymentById(@PathVariable("id") Long id);

    /**
     * 测试超时
     *
     * @return
     */
    @GetMapping("/payment/feign/timeout")
    String paymentFeignTimeout();
}
