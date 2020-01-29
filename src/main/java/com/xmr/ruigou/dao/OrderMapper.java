package com.xmr.ruigou.dao;

import com.xmr.ruigou.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Long orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    Order selectByUserIdAndOrderNum(@Param("userId") Long userId, @Param("orderNum") Long orderNum);

    Order selectByOrderNum(Long orderNum);

    List<Order> selectByUserId(Long userId);

    List<Order> selectAllOrder();
}