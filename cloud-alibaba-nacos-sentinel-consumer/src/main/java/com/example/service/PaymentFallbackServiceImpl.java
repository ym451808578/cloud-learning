package com.example.service;

import com.example.common.entity.CommonResult;
import com.example.common.entity.Payment;
import org.springframework.stereotype.Component;

/**
 * @author 45180
 */
@Component
public class PaymentFallbackServiceImpl implements PaymentService {
    @Override
    public CommonResult getPayment(Long id) {
        return new CommonResult(444, "feign自定义降级提示，O(∩_∩)O哈哈~", new Payment(id, null));
    }
}
