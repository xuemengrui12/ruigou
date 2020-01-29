package com.xmr.ruigou.dao;

import com.xmr.ruigou.pojo.AliUser;

import java.util.List;

public interface AliUserMapper {
    int deleteByPrimaryKey(Long aliUserId);

    int insert(AliUser record);

    int insertSelective(AliUser record);

    AliUser selectByPrimaryKey(Long aliUserId);

    int updateByPrimaryKeySelective(AliUser record);

    int updateByPrimaryKey(AliUser record);

    List<AliUser> selectByUserId(Long userId);

}