package com.xmr.ruigou.dao;

import com.xmr.ruigou.pojo.AliOrder;

import java.util.List;

public interface AliOrderMapper {
    int deleteByPrimaryKey(Long aliOrderId);

    int insert(AliOrder record);

    int insertSelective(AliOrder record);

    AliOrder selectByPrimaryKey(Long aliOrderId);

    int updateByPrimaryKeySelective(AliOrder record);

    int updateByPrimaryKeyWithBLOBs(AliOrder record);

    int updateByPrimaryKey(AliOrder record);

    List<AliOrder> selectAll();

    List<AliOrder> selectByNickName(String nickName);
}