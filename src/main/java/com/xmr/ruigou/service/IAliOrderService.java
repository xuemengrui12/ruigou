package com.xmr.ruigou.service;


import com.xmr.ruigou.common.ServerResponse;
import com.xmr.ruigou.pojo.AliOrder;

import java.util.List;

/**
 * Created by xmr on 2019/12/14.
 */
public interface IAliOrderService {
    //供后台调用
    ServerResponse addOrUpdateAliOrder(AliOrder aliOrder);

    ServerResponse deleteAliOrder(Long aliOrderId);

    ServerResponse<List<AliOrder>> getAllAliOrder();

    //供后台查看某个用户的订单
    ServerResponse<List<AliOrder>> getAliOrderByUserName(String userName, int pageNum, int pageSize);

    ServerResponse<List<AliOrder>> getAliOrderByUserId(Long userId, int pageNum, int pageSize);
}
