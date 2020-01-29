package com.xmr.ruigou.controller.backend;

import com.xmr.ruigou.common.Const;
import com.xmr.ruigou.common.ResponseCode;
import com.xmr.ruigou.common.ServerResponse;
import com.xmr.ruigou.pojo.AliOrder;
import com.xmr.ruigou.pojo.User;
import com.xmr.ruigou.service.IAliOrderService;
import com.xmr.ruigou.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by xmr on 2019/12/14.
 */
@RestController
@RequestMapping("/manage/ali_order")
public class AliOrderManageController {

    @Autowired
    private IAliOrderService aliOrderService;
    @Autowired
    private IUserService userService;

    @RequestMapping("/add_update")
    public ServerResponse addOrUpdateAliOrder(AliOrder aliOrder, HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        ServerResponse response = userService.checkAdminRole(user);
        if (response.isSuccess()) {
            return aliOrderService.addOrUpdateAliOrder(aliOrder);
        } else {
            return ServerResponse.createByErrorMessage("权限不足");
        }
    }

    @RequestMapping("/delete")
    public ServerResponse deleteAliOrder(Long aliOrderId, HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        ServerResponse response = userService.checkAdminRole(user);
        if (response.isSuccess()) {
            if (aliOrderId == null) {
                return ServerResponse.createByErrorMessage("无权限操作,需要管理员权限");
            }
            return aliOrderService.deleteAliOrder(aliOrderId);

        }
        return ServerResponse.createByErrorMessage("删除失败");
    }

    @RequestMapping("/list")
    public ServerResponse aliOrderList(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        ServerResponse response = userService.checkAdminRole(user);
        if (response.isSuccess()) {
            return aliOrderService.getAllAliOrder();
        } else {
            return ServerResponse.createByErrorMessage("无权限操作,需要管理员权限");
        }
    }

    @RequestMapping("/search")
    public ServerResponse<List<AliOrder>> orderSearch(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                      @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                                      String userName, HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录管理员");
        }
        if (userService.checkAdminRole(user).isSuccess()) {
            //填充我们增加产品的业务逻辑
            return aliOrderService.getAliOrderByUserName(user.getUserName(), pageNum, pageSize);
        } else {
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }
}
