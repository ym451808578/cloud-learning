package com.example.service.impl;

import cn.hutool.core.lang.UUID;
import com.example.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;

/**
 * @author Castle
 * @Date 2021/4/6 14:55
 */
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {
    @Resource
    private MessageChannel output;

    @Override
    public void send() {
        String serial = UUID.randomUUID().toString();
        System.out.println("============serial:" + serial);
        output.send(MessageBuilder.withPayload(serial).build());
    }
}
