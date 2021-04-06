package com.example.controller;

import com.example.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Castle
 * @Date 2021/4/6 15:00
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/send/message")
    public String sendMessage() {
        messageProvider.send();
        return "Message is send";
    }
}
