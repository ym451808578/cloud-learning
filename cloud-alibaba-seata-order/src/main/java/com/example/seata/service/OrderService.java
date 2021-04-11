package com.example.seata.service;

import com.example.seata.entity.Order;

/**
 * @author 45180
 */
public interface OrderService {

    /**
     * 创建订单
     *
     * @param order
     * @return
     */
    int insert(Order order);
}
