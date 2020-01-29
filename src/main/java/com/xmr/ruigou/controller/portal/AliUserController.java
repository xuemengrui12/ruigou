package com.xmr.ruigou.controller.portal;

import com.xmr.ruigou.common.Const;
import com.xmr.ruigou.common.ResponseCode;
import com.xmr.ruigou.common.ServerResponse;
import com.xmr.ruigou.pojo.AliUser;
import com.xmr.ruigou.pojo.User;
import com.xmr.ruigou.service.IAliUserService;
import com.xmr.ruigou.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 淘宝账号的CRUD接口
 * Created by xmr on 2019/12/14.
 */
@RestController
@RequestMapping("/ali_user")
public class AliUserController {
    @Autowired
    private IAliUserService iAliUserService;
    @Autowired
    private IUserService iUserService;

    @RequestMapping("/add_update")
    public ServerResponse addOrUpdate(AliUser aliUser, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(
                    ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iAliUserService.addOrUpdate(aliUser);
    }

    @RequestMapping("/delete")
    public ServerResponse deleteAliUserByUserId(HttpSession httpSession) {
        User user = (User) httpSession.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(
                    ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iAliUserService.deleteAliUserByUserId(user.getUserId());
    }

    @RequestMapping("search")
    public ServerResponse searchAliUserByUserId(HttpSession httpSession){
        User user = (User) httpSession.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(
                    ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iAliUserService.selectAliUserByUserId(user.getUserId());
    }
}
