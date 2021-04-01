package com.example.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Castle
 * @Date 2021/4/1 8:42
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLogger() {
        return Logger.Level.FULL;
    }
}
