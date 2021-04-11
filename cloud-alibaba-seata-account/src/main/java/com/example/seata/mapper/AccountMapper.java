package com.example.seata.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author 45180
 */
@Mapper
public interface AccountMapper {

    /**
     * 扣减余额
     *
     * @param userId
     * @param money
     */
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
