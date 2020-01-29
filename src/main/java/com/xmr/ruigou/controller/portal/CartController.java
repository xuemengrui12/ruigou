package com.xmr.ruigou.controller.portal;

import com.xmr.ruigou.common.Const;
import com.xmr.ruigou.common.ResponseCode;
import com.xmr.ruigou.common.ServerResponse;
import com.xmr.ruigou.pojo.User;
import com.xmr.ruigou.service.ICartService;
import com.xmr.ruigou.vo.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 购物车接口，暂未使用
 * Created by xmr on 2019/12/10.
 */
@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private ICartService iCartService;


    @RequestMapping("/list")
    @ResponseBody
    public ServerResponse<CartVo> list(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.list(user.getUserId());
    }

    @RequestMapping("/add")
    @ResponseBody
    public ServerResponse<CartVo> add(Long productId, Integer count, HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.add(user.getUserId(), productId, count);
    }


    @RequestMapping("/update")
    @ResponseBody
    public ServerResponse<CartVo> update(Long productId, Integer count, HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.update(user.getUserId(), productId, count);
    }

    @RequestMapping("/delete_product")
    @ResponseBody
    public ServerResponse<CartVo> deleteProduct(String productIds, HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.deleteProduct(user.getUserId(), productIds);
    }


    /**
     * 全选
     *
     * @param session
     * @return
     */
    @RequestMapping("/select_all")
    @ResponseBody
    public ServerResponse<CartVo> selectAll(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.selectOrUnSelect(user.getUserId(), null, Const.Cart.CHECKED);
    }

    /**
     * 全反选
     *
     * @param session
     * @return
     */
    @RequestMapping("/un_select_all")
    @ResponseBody
    public ServerResponse<CartVo> unSelectAll(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.selectOrUnSelect(user.getUserId(), null, Const.Cart.UN_CHECKED);
    }


    /**
     * 单独选
     *
     * @param productId
     * @param session
     * @return
     */
    @RequestMapping("/select")
    @ResponseBody
    public ServerResponse<CartVo> select(Long productId, HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.selectOrUnSelect(user.getUserId(), productId, Const.Cart.CHECKED);
    }

    /**
     * 单独反选
     *
     * @param productId
     * @param session
     * @return
     */
    @RequestMapping("/un_select")
    @ResponseBody
    public ServerResponse<CartVo> unSelect(Long productId, HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.selectOrUnSelect(user.getUserId(), productId, Const.Cart.UN_CHECKED);
    }


    /**
     * 查询当前用户的购物车里面的产品数量,如果一个产品有10个,那么数量就是10.
     *
     * @param session
     * @return
     */
    @RequestMapping("/get_cart_product_count")
    @ResponseBody
    public ServerResponse<Integer> getCartProductCount(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createBySuccess(0);
        }
        return iCartService.getCartProductCount(user.getUserId());
    }


}
