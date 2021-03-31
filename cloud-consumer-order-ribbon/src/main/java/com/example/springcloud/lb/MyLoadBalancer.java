package com.example.springcloud.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 重写
 * com.netflix.loadbalancer.RoundRobinRule
 * 轮询策略
 *
 * @author Castle
 * @Date 2021/3/31 11:19
 */
@Component
@Slf4j
public class MyLoadBalancer implements LoadBalancer {

    /**
     * 记录当前请求的次数，默认为0，重启后重置为0
     */
    private AtomicInteger currentRequestTimes = new AtomicInteger(0);

    /**
     * 获取当前的请求次数,并且请求次数加1
     * <p>
     * 原代码是一个典型的Atomically increments by one the current value
     *
     * @return
     */
    private final int getCurrentTimesAndIncrement() {
        int current;
        int next;
        do {
            current = this.currentRequestTimes.get();
            log.info("=====AtomicInteger currentTimes的数值：" + current);
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!this.currentRequestTimes.compareAndSet(current, next));
        //如果当前值与期望值一致，则代表没有其他用户请求，可以修改，请求次数+1；
        //如果不一致，则代表有其他用户操作该值，自旋等待直到当前值与期望值一致。
        log.info("=====当前访问次数=====：" + next);
        return next;
    }

    /**
     * 实际调用服务器位置下标=第几次请求数%集群总数量
     *
     * @param serviceInstances
     * @return
     */
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getCurrentTimesAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
