package com.expample.controller;

import com.example.common.entity.CommonResult;
import com.example.common.entity.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author 45180
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String portValue;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();

    static {
        hashMap.put(1L, new Payment(1L, "serial210410001"));
        hashMap.put(2L, new Payment(2L, "serial210410002"));
        hashMap.put(3L, new Payment(3L, "serial210410003"));
    }

    @GetMapping("/payment/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        Payment payment = hashMap.get(id);
        CommonResult result = new CommonResult(200, "From port: " + portValue, payment);
        return result;
    }
}
