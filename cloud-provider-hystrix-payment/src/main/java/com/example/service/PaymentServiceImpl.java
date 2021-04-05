package com.example.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

/**
 * @author 45180
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentInfoOk(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "   Payment Info OK, id: " + id;
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfoTimeout(Integer id) {
        int timeMillis = 10000;
        //int time = 10 / 0;
        try {
            Thread.sleep(timeMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "   Payment Info Timeout, id: " + id + "\t" + "O(∩_∩)O哈哈~，耗时：" + timeMillis;
    }

    @Override
    public String paymentInfoTimeoutHandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "   Payment Info Timeout Handler, 系统繁忙或运行报错，o(╥﹏╥)o呜呜~";
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("============id不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号： " + serialNumber;
    }

    @Override
    public String paymentCircuitBreakerFallback(Integer id) {
        return "id不能为负数，请检查后重试。。o(╥﹏╥)o   id：" + id;
    }
}
