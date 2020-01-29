package com.xmr.ruigou.service.impl;

import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.xmr.ruigou.common.ServerResponse;
import com.xmr.ruigou.dao.AliOrderMapper;
import com.xmr.ruigou.dao.AliUserMapper;
import com.xmr.ruigou.dao.UserMapper;
import com.xmr.ruigou.pojo.AliOrder;
import com.xmr.ruigou.pojo.AliUser;
import com.xmr.ruigou.pojo.User;
import com.xmr.ruigou.service.IAliOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by xmr on 2019/12/14.
 */
@Service
public class AliOrderServiceImpl implements IAliOrderService {
    @Autowired
    private AliOrderMapper aliOrderMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AliUserMapper aliUserMapper;

    @Override
    public ServerResponse addOrUpdateAliOrder(AliOrder aliOrder) {
        Long aliOrderId = aliOrder.getAliOrderId();
        AliOrder order = aliOrderMapper.selectByPrimaryKey(aliOrderId);
        if (order != null) {
            //如果是更新数据库
            int count = aliOrderMapper.updateByPrimaryKeySelective(aliOrder);
            if (count > 0) {
                return ServerResponse.createBySuccessMessage("更新淘宝订单成功");
            }
        } else {
            int count = aliOrderMapper.insertSelective(aliOrder);
            if (count > 0) {
                return ServerResponse.createBySuccessMessage("添加淘宝订单成功");
            }
        }
        return ServerResponse.createByErrorMessage("操作失败");
    }

    @Override
    public ServerResponse deleteAliOrder(Long aliOrderId) {
        int count = aliOrderMapper.deleteByPrimaryKey(aliOrderId);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("删除淘宝订单成功");
        }
        return ServerResponse.createByErrorMessage("删除失败");
    }

    @Override
    public ServerResponse<List<AliOrder>> getAllAliOrder() {
        List<AliOrder> aliOrderList = aliOrderMapper.selectAll();
        if (CollectionUtils.isEmpty(aliOrderList)) {
            return ServerResponse.createByErrorMessage("未查到数据");
        }
        return ServerResponse.createBySuccess(aliOrderList);
    }

    @Override
    public ServerResponse<List<AliOrder>> getAliOrderByUserName(String userName, int pageNum, int pageSize) {
        User user=userMapper.selectByUserName(userName);
        if (user==null){
            ServerResponse.createByErrorMessage("用户不存在");
        }
        PageHelper.startPage(pageNum, pageSize);
        return getAliOrders(user.getUserId());
    }

    /**
     * 一个用户可以绑定多个淘宝账号，因此需要查询用户绑定所有淘宝账号的订单
     *
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public ServerResponse<List<AliOrder>> getAliOrderByUserId(Long userId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return getAliOrders(userId);
    }

    private ServerResponse<List<AliOrder>> getAliOrders(Long userId) {
        //根据userId查出该用户绑定的所有淘宝账号信息
        List<AliUser> aliUserList = aliUserMapper.selectByUserId(userId);
        if (CollectionUtils.isEmpty(aliUserList)) {
            return ServerResponse.createByErrorMessage("用户未绑定淘宝账号");
        }
        List<AliOrder> aliOrderList = Lists.newArrayList();
        aliUserList.forEach(aliUser -> {
            String nickName = aliUser.getNickName();
            List<AliOrder> aliOrders = aliOrderMapper.selectByNickName(nickName);
            if (!CollectionUtils.isEmpty(aliOrderList)) {
                aliOrderList.addAll(aliOrders);
            }
        });
        return ServerResponse.createBySuccess(aliOrderList);
    }

}
