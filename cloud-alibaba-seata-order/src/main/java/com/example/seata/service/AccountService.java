package com.example.seata.service;

import com.example.common.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author 45180
 */
@FeignClient(value = "seata-account")
public interface AccountService {

    /**
     * 账户余额减少
     *
     * @param userId
     * @param money
     * @return
     */
    @GetMapping("/account/decrease")
    CommonResult decreaseAccount(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
