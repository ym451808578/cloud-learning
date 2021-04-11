package com.example.seata.service.impl;

import com.example.seata.mapper.StorageMapper;
import com.example.seata.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 45180
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageMapper storageMapper;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("************开始扣减库存");
        storageMapper.decrease(productId, count);
        log.info("************扣减库存成功");
    }
}
