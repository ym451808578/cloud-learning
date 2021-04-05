package com.example.service;

/**
 * @author 45180
 */
public interface PaymentService {

    /**
     * 模拟正常业务
     *
     * @param id
     * @return
     */
    String paymentInfoOk(Integer id);

    /**
     * 模拟超时
     *
     * @param id
     * @return
     */
    String paymentInfoTimeout(Integer id);

    /**
     * hystrix降级方法
     *
     * @param id
     * @return
     */
    String paymentInfoTimeoutHandler(Integer id);

    /**
     * 服务熔断
     *
     * @param id
     * @return
     */
    String paymentCircuitBreaker(Integer id);

    /**
     * 熔断返回方法
     *
     * @param id
     * @return
     */
    String paymentCircuitBreakerFallback(Integer id);
}
