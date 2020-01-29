package com.xmr.ruigou.dao;

import com.xmr.ruigou.pojo.UserMap;

public interface UserMapMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(UserMap record);

    int insertSelective(UserMap record);

    UserMap selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(UserMap record);

    int updateByPrimaryKey(UserMap record);

    UserMap selectByDefaultChild();

}