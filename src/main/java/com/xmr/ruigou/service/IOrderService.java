package com.xmr.ruigou.service;

import com.github.pagehelper.PageInfo;
import com.xmr.ruigou.common.ServerResponse;
import com.xmr.ruigou.vo.OrderVo;

import java.util.Map;

/**
 * Created by xmr on 2019/12/12.
 */
public interface IOrderService {
    ServerResponse pay(Long orderNo, Long userId, String path);

    ServerResponse aliCallback(Map<String, String> params);

    ServerResponse queryOrderPayStatus(Long userId, Long orderNo);

    ServerResponse createOrder(Long userId, Integer shippingId);

    ServerResponse<String> cancel(Long userId, Long orderNo);

    ServerResponse getOrderCartProduct(Long userId);

    ServerResponse<OrderVo> getOrderDetail(Long userId, Long orderNo);

    ServerResponse<PageInfo> getOrderList(Long userId, int pageNum, int pageSize);

    //backend
    ServerResponse<PageInfo> manageList(int pageNum, int pageSize);

    ServerResponse<OrderVo> manageDetail(Long orderNo);

    ServerResponse<PageInfo> manageSearch(Long orderNo, int pageNum, int pageSize);

    ServerResponse<String> manageSendGoods(Long orderNo);

}
