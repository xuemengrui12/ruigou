package com.xmr.ruigou.dao;

import com.xmr.ruigou.pojo.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {
    int deleteByPrimaryKey(Long cartId);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Long cartId);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);

    Cart selectCartByUserIdAndProductId(@Param("userId") Long userId, @Param("productId") Long productId);

    List<Cart> selectCartByUserId(Long userId);

    int selectCartProductCheckedStatusByUserId(Long userId);

    int deleteByUserIdProductIds(@Param("userId") Long userId, @Param("productIdList") List<String> productIdList);

    int checkedOrUncheckedProduct(@Param("userId") Long userId, @Param("productId") Long productId, @Param("checked") Integer checked);

    int selectCartProductCount(@Param("userId") Long userId);

    List<Cart> selectCheckedCartByUserId(Long userId);
}