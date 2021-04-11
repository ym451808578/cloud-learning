package com.example.seata.service.impl;

import com.example.seata.entity.Order;
import com.example.seata.mapper.OrderMapper;
import com.example.seata.service.AccountService;
import com.example.seata.service.OrderService;
import com.example.seata.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 45180
 */

@Service
@Slf4j
@GlobalTransactional(name = "order_transactional", rollbackFor = Exception.class)
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;
    @Resource
    private AccountService accountService;
    @Resource
    private StorageService storageService;

    @Override
    public int insert(Order order) {
        log.info("**************开始创建订单");
        orderMapper.insert(order);
        log.info("**************订单创建成功");
        log.info("=========================");
        log.info("**************开始扣减库存");
        storageService.decreaseStorage(order.getProductId(), order.getCount());
        log.info("**************扣减库存成功");
        log.info("=========================");
        log.info("**************开始扣减账户余额");
        accountService.decreaseAccount(order.getUserId(), order.getMoney());
        log.info("*************账户余额扣减成功");
        return 1;
    }
}
