package com.xmr.ruigou.dao;

import com.xmr.ruigou.pojo.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);

    List<OrderItem> getByOrderNumAndUserId(@Param("orderNum") Long orderNo, @Param("userId") Long userId);

    List<OrderItem> getByOrderNum(@Param("orderNum") Long orderNum);

    void batchInsert(@Param("orderItemList") List<OrderItem> orderItemList);

}