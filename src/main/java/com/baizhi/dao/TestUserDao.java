package com.baizhi.dao;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;

public interface TestUserDao {
    //登陆
    User login(@Param("userName") String userName,@Param("password") String password);
    //注册
    void zhuce(User user);
}
