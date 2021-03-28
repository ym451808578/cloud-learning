package com.example.springcloud.service;


import com.example.common.entity.Payment;

/**
 * @author 45180
 */
public interface PaymentService {
    /**
     * 增加
     *
     * @param payment
     * @return
     */
    public int create(Payment payment);

    /**
     * 根据Id查找
     *
     * @param id
     * @return
     */
    public Payment getPaymentById(Long id);
}
