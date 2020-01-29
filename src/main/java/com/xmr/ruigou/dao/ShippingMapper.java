package com.xmr.ruigou.dao;

import com.xmr.ruigou.pojo.Shipping;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShippingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shipping record);

    int insertSelective(Shipping record);

    Shipping selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shipping record);

    int updateByPrimaryKey(Shipping record);

    int updateByShipping(Shipping record);

    int deleteByShippingIdAndUserId(@Param(value = "userId") Long userId, @Param(value = "shippingId")Integer shippingId);

    Shipping selectByShippingIdAndUserId(@Param(value = "userId") Long userId, @Param(value = "shippingId")Integer shippingId);

    List<Shipping> selectByUserId(Long userId);
}