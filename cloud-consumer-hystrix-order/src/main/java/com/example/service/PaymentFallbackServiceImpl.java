package com.example.service;

import org.springframework.stereotype.Component;

/**
 * @author 45180
 */
@Component
public class PaymentFallbackServiceImpl implements PaymentHystrixService {
    @Override
    public String paymentInfoOk(Integer id) {
        return "来自Payment Info Ok的异常处理";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "来自Payment Info Timeout的异常处理";
    }
}
