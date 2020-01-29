package com.xmr.ruigou.controller.portal;

import com.xmr.ruigou.common.Const;
import com.xmr.ruigou.common.ResponseCode;
import com.xmr.ruigou.common.ServerResponse;
import com.xmr.ruigou.pojo.User;
import com.xmr.ruigou.service.IAliOrderService;
import com.xmr.ruigou.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by xmr on 2019/12/14.
 */
@RestController
@RequestMapping("/ali_order")
public class AliOrderController {

    @Autowired
    private IAliOrderService aliOrderService;
    @Autowired
    private IUserService userService;


    @RequestMapping("/list")
    public ServerResponse aliOrderList(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                       @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                       HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        aliOrderService.getAliOrderByUserId(user.getUserId(), pageNum, pageSize);
        return ServerResponse.createByErrorMessage("无权限操作,需要管理员权限");
    }

//    @RequestMapping("/search")
//    public ServerResponse<List<AliOrder>> orderSearch(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
//                                                      @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
//                                                      String nickName, HttpSession session) {
//        User user = (User) session.getAttribute(Const.CURRENT_USER);
//        if (user == null) {
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录管理员");
//
//        }
//        if (userService.checkAdminRole(user).isSuccess()) {
//            return aliOrderService.getAliOrderByNickName(nickName, pageNum, pageSize);
//        } else {
//            return ServerResponse.createByErrorMessage("无权限操作");
//        }
//    }
}
