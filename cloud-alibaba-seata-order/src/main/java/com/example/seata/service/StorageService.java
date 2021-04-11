package com.example.seata.service;

import com.example.common.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 45180
 */
@FeignClient(value = "seata-storage")
public interface StorageService {

    /**
     * 库存减少
     *
     * @param productId
     * @param count
     * @return
     */
    @GetMapping("/storage/decrease")
    CommonResult decreaseStorage(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
