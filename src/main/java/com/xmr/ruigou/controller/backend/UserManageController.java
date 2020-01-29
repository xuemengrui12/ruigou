package com.xmr.ruigou.controller.backend;

import com.alibaba.fastjson.JSONObject;
import com.xmr.ruigou.common.Const;
import com.xmr.ruigou.common.ServerResponse;
import com.xmr.ruigou.pojo.User;
import com.xmr.ruigou.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 后台管理接口
 * Created by xmr on 2019/12/5.
 */
@RestController
@RequestMapping("/manage/user")
public class UserManageController {
    @Autowired
    private IUserService iUserService;

    @RequestMapping("/login/index")
    public ModelAndView liginIndex(HttpServletRequest request) {
        return new ModelAndView("/login/index");
    }

    @RequestMapping("/register/index")
    public ModelAndView registerIndex(HttpServletRequest request) {return new ModelAndView("/register/index");}

    @RequestMapping("/pwd/forgot")
    public ModelAndView forgotIndex(HttpServletRequest request) {
        return new ModelAndView("/pwd/forgot");
    }

    @RequestMapping(value="/login",method = RequestMethod.POST)
    public ServerResponse<User> login(@RequestBody JSONObject jsonObject, HttpSession session){
        System.out.println(jsonObject.toJSONString());
        String username = jsonObject.get("username").toString();
        String password = jsonObject.get("password").toString();
//        ServerResponse<User> response = null;
        ServerResponse<User> response = iUserService.login(username,password);
        if(response.isSuccess()){
//            return response;
            User user = response.getData();
            if(user.getRole() == Const.Role.ROLE_ADMIN){
                //说明登录的是管理员
                session.setAttribute(Const.CURRENT_USER,user);
                return response;
            }else{
                return ServerResponse.createByErrorMessage("不是管理员,无法登录");
            }
        }
        return response;
    }

    @RequestMapping(value="/register",method = RequestMethod.POST)
    public String register(@RequestBody User user) {
        System.out.println(JSONObject.toJSONString(user));
        return "ok";
    }
}
