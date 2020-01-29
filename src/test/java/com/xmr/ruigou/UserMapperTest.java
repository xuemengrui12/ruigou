package com.xmr.ruigou;

import com.xmr.ruigou.dao.UserMapper;
import com.xmr.ruigou.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created by xmr on 2019/12/5.
 */

@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() throws Exception {
        User user = new User();
        user.setUserName("xxx");
        user.setPassword("123456");
        user.setEmail("bf9958@126.com");
        user.setPhone("18810682976");
        user.setRole(0);
        user.setQuestion("1+1");
        user.setAnswer("2");
        userMapper.insert(user);

    }

}
