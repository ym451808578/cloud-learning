package com.example.seata.controller;

import com.example.common.entity.CommonResult;
import com.example.seata.entity.Order;
import com.example.seata.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 45180
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order")
    public CommonResult order(Order order) {
        int result = orderService.insert(order);
        if (result > 0) {
            return new CommonResult(200, "订单创建成功");
        }
        return new CommonResult(444, "订单创建失败");
    }
}
