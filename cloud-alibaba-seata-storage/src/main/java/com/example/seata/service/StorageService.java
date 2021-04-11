package com.example.seata.service;

/**
 * @author 45180
 */
public interface StorageService {

    /**
     * 扣减库存
     *
     * @param productId
     * @param count
     */
    void decrease(Long productId, Integer count);
}
