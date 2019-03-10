package com.baizhi.service;

import com.baizhi.entity.Admin;

public interface AdminService {
    //登陆
    Admin quieryOneByNameANDPassword(String name,String password);
    //注销
    void remove(String id);
    //改密码
    void updatePassword(Admin admin);
    //注册
    void addAdmin(Admin admin);
}
