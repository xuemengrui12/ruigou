package com.xmr.ruigou.service;

import com.xmr.ruigou.common.ServerResponse;
import com.xmr.ruigou.pojo.User;

/**
 * Created by xmr on 2019/12/4.
 */
public interface IUserService {
    //用户登录
    ServerResponse<User> login(String username, String password);

    //用户注册
    ServerResponse<String> register(User user,Long inviteCode);

    //检测用户名和email
    ServerResponse<String> checkValid(String str, String type);

    //选取密码提示
    ServerResponse selectQuestion(String username);

    //验证密码
    ServerResponse<String> checkAnswer(String username, String question, String answer);

    ServerResponse<String> forgetResetPassword(String username, String passwordNew, String forgetToken);

    //重置密码
    ServerResponse<String> resetPassword(String passwordOld, String passwordNew, User user);

    ServerResponse<User> updateInformation(User user);

    ServerResponse<User> getInformation(Long userId);

    ServerResponse checkAdminRole(User user);

}
