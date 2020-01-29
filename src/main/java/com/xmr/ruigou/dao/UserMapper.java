package com.xmr.ruigou.dao;

import com.xmr.ruigou.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int checkUsername(String userName);

    int checkEmail(String email);

    User selectLogin(@Param("userName") String userName, @Param("password") String password);

    String selectQuestionByUsername(String userName);

    int checkAnswer(@Param("userName") String userName, @Param("question") String question, @Param("answer") String answer);

    int updatePasswordByUsername(@Param("userName") String userName, @Param("passwordNew") String passwordNew);

    int checkPassword(@Param(value = "password") String password, @Param("userId") Long userId);

    int checkEmailByUserId(@Param(value = "email") String email, @Param(value = "userId") Long userId);

    User selectByUserName(String userName);

}