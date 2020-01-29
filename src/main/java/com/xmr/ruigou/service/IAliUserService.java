package com.xmr.ruigou.service;

import com.xmr.ruigou.common.ServerResponse;
import com.xmr.ruigou.pojo.AliUser;

import java.util.List;

/**
 * Created by xmr on 2019/12/14.
 */
public interface IAliUserService {
    ServerResponse<String> addOrUpdate(AliUser aliUser);
    ServerResponse<Integer> deleteAliUserByUserId(Long userId);
    ServerResponse<List<AliUser>> selectAliUserByUserId(Long userId);

}
