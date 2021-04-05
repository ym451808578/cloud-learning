package com.example.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 45180
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator myRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("test_path1", r -> r.path("/news").uri("https://news.baidu.com")).build();
        routes.route("test_path2", r -> r.path("/163").uri("https://www.163.com")).build();
        return routes.build();
    }
}
