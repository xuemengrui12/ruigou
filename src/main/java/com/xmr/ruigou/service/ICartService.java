package com.xmr.ruigou.service;

import com.xmr.ruigou.common.ServerResponse;
import com.xmr.ruigou.vo.CartVo;

/**
 * Created by xmr on 2019/12/9.
 */
public interface ICartService {
    ServerResponse<CartVo> add(Long userId, Long productId, Integer count);
    ServerResponse<CartVo> update(Long userId,Long productId,Integer count);
    ServerResponse<CartVo> deleteProduct(Long userId,String productIds);
    ServerResponse<CartVo> list (Long userId);
    ServerResponse<CartVo> selectOrUnSelect (Long userId,Long productId,Integer checked);
    ServerResponse<Integer> getCartProductCount(Long userId);
}
