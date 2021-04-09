package com.example.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.common.entity.CommonResult;
import com.example.common.entity.Payment;
import com.example.handler.MyBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Castle
 * @Date 2021/4/9 15:10
 */
@RestController
public class LimitController {

    @GetMapping("/limit/url")
    @SentinelResource(value = "limit_url", blockHandler = "handlerException")
    public CommonResult byUrl() {

        return new CommonResult(200, "按url限流测试，结果OK", new Payment(2021L, "210409002"));
    }

    public CommonResult handlerException(BlockException exception) {
        return new CommonResult(400, "服务不可以用啊，亲~" + exception.getClass().getCanonicalName());
    }

    @GetMapping("/limit/my")
    @SentinelResource(value = "limit_my", blockHandlerClass = MyBlockHandler.class, blockHandler = "handlerException")
    public CommonResult customerBlockHandler() {
        return new CommonResult(200, "按自定义handler进行限流测试，目前结果OK", new Payment(2021L, "210409003"));
    }
}
