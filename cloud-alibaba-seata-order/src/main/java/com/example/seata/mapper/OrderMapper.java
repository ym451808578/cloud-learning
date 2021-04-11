package com.example.seata.mapper;

import com.example.seata.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 45180
 */
@Mapper
public interface OrderMapper {

    /**
     * 新增
     *
     * @param order
     * @return
     */
    int insert(Order order);

    /**
     * 更新
     *
     * @param id
     * @param status
     * @return
     */
    int update(@Param("id") Long id, @Param("status") Integer status);
}
