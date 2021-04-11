package com.example.seata.controller;

import com.example.common.entity.CommonResult;
import com.example.seata.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author 45180
 */
@RestController
public class AccountController {

    @Resource
    private AccountService accountService;

    @RequestMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountService.decrease(userId, money);
        return new CommonResult(200, "扣减余额成功");
    }
}
