package com.example.seata.service.impl;

import com.example.seata.mapper.AccountMapper;
import com.example.seata.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author 45180
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("*********开始扣减账户余额");
        accountMapper.decrease(userId, money);
        log.info("*********扣减账户余额成功");
    }
}
