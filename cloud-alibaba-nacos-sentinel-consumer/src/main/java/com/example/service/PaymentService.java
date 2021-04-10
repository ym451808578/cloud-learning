package com.example.service;

import com.example.common.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 45180
 */
@FeignClient(value = "nacos-sentinel-payment", fallback = PaymentFallbackServiceImpl.class)
public interface PaymentService {

    /**
     * 获取payment
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id);
}
