package com.baizhi.service.impl;

import com.baizhi.aop.LogAnnotation;
import com.baizhi.dao.TestUserDao;
import com.baizhi.entity.User;
import com.baizhi.service.TestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("testUserService")
@Transactional
public class TestUserServiceImpl implements TestUserService {
    @Autowired
    private TestUserDao td;

    public void setTd(TestUserDao td) {
        this.td = td;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public User login(String userName, String password) {
        return td.login(userName, password);
    }

    @Override
    @LogAnnotation(name="添加用户")
    public void zhuce(User user) {
        td.zhuce(user);
    }
}
