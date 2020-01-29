package com.xmr.ruigou.service.impl;

import com.xmr.ruigou.common.ServerResponse;
import com.xmr.ruigou.dao.AliUserMapper;
import com.xmr.ruigou.pojo.AliUser;
import com.xmr.ruigou.service.IAliUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xmr on 2019/12/14.
 */
@Service
public class AliUserServiceImpl implements IAliUserService {
    @Autowired
    private AliUserMapper aliUserMapper;

    @Override
    public ServerResponse<String> addOrUpdate(AliUser aliUser) {
        if (aliUser.getAliUserId() == null) {
            int count = aliUserMapper.insert(aliUser);
            if (count > 0) {
                return ServerResponse.createBySuccessMessage("绑定淘宝账号成功");
            } else {
                return ServerResponse.createByErrorMessage("绑定淘宝账号失败");
            }
        } else {
            int count = aliUserMapper.updateByPrimaryKey(aliUser);
            if (count > 0) {
                return ServerResponse.createBySuccessMessage("绑定淘宝账号成功");
            } else {
                return ServerResponse.createByErrorMessage("绑定淘宝账号失败");
            }
        }

    }

    @Override
    public ServerResponse<Integer> deleteAliUserByUserId(Long userId) {
        if (userId == null) {
            return ServerResponse.createByErrorMessage("参数错误");
        }
        int count = aliUserMapper.deleteByPrimaryKey(userId);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("删除淘宝账号成功");
        }
        return ServerResponse.createByErrorMessage("删除淘宝账号失败");
    }

    @Override
    public ServerResponse<List<AliUser>> selectAliUserByUserId(Long userId) {
        if (userId == null) {
            return ServerResponse.createByErrorMessage("参数错误");
        }
        List<AliUser> aliUserList=aliUserMapper.selectByUserId(userId);
        return ServerResponse.createBySuccess(aliUserList);
    }
}
