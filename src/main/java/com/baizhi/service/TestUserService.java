package com.baizhi.service;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;

public interface TestUserService {
    //登陆
    User login(String userName,String password);
    //注册
    void zhuce(User user);
}
