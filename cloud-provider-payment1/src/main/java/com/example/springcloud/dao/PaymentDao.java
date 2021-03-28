package com.example.springcloud.dao;

import com.example.common.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 45180
 */
@Mapper
public interface PaymentDao {
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
    public Payment getPaymentById(@Param("id") Long id);
}

