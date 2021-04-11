package com.example.seata.service;

import java.math.BigDecimal;

/**
 * @author 45180
 */
public interface AccountService {
    /**
     * 扣减余额
     *
     * @param userId
     * @param money
     */
    void decrease(Long userId, BigDecimal money);
}
