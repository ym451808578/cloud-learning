package com.example.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 自定义负载均衡接口
 *
 * @author Castle
 * @Date 2021/3/31 11:17
 */
public interface LoadBalancer {
    /**
     * 获取服务实例
     *
     * @param serviceInstances
     * @return
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
