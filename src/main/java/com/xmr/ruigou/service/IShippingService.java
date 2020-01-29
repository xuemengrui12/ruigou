package com.xmr.ruigou.service;

import com.github.pagehelper.PageInfo;
import com.xmr.ruigou.common.ServerResponse;
import com.xmr.ruigou.pojo.Shipping;

/**
 * Created by xmr on 2019/12/10.
 */
public interface IShippingService {
    ServerResponse add(Long userId, Shipping shipping);
    ServerResponse<String> delete(Long userId, Integer shippingId);
    ServerResponse update(Long userId, Shipping shipping);
    ServerResponse<Shipping> select(Long userId, Integer shippingId);
    ServerResponse<PageInfo> list(Long userId, int pageNum, int pageSize);
}
