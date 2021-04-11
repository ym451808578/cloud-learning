package com.example.seata.controller;

import com.example.common.entity.CommonResult;
import com.example.seata.service.StorageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 45180
 */
@RestController
public class StorageController {

    @Resource
    private StorageService storageService;

    @RequestMapping("/storage/decrease")
    public CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count) {
        System.out.println("productId:" + productId);
        System.out.println("count:" + count);
        storageService.decrease(productId, count);
        return new CommonResult(200, "扣减库存成功");
    }
}
