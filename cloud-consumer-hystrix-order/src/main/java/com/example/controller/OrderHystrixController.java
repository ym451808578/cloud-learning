package com.example.controller;

import com.example.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 45180
 */
@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "paymentGlobalHandler")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
//    @HystrixCommand
    public String paymentInfoOk(@PathVariable("id") Integer id) {
//        int age = 10 / 0;
        String result = paymentHystrixService.paymentInfoOk(id);
        log.info("=========" + result);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
//    })
    public String paymentInfoTimeout(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfoTimeout(id);
        log.info("=========" + result);
        return result;
    }

//    /**
//     * hystrix降级方法
//     *
//     * @param id
//     * @return
//     */
//    public String paymentInfoTimeoutHandler(@PathVariable("id") Integer id) {
//        return "我是消费者，支付系统繁忙或异常，请10秒后再次尝试，o(╥﹏╥)o";
//    }
//
//    /**
//     * hystrix全局降级方法
//     *
//     * @param
//     * @return
//     */
//    public String paymentGlobalHandler() {
//        return "我是消费者Global异常处理，支付系统繁忙或异常，请10秒后再次尝试，o(╥﹏╥)o";
//    }
}
