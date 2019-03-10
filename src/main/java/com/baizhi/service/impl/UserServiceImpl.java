package com.baizhi.service.impl;

import com.baizhi.aop.LogAnnotation;
import com.baizhi.dao.UserDao;
import com.baizhi.dto.PageDTO;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao ud;


    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public PageDTO<User> findAllPage(Integer page, Integer rows) {
        Integer totalCount = ud.findTotalCount();
        List<User> users = ud.finAllPage(page, rows);
        PageDTO<User> p = new PageDTO<User>();
        p.setTotal(totalCount);
        p.setRows(users);
        return p;
    }

    @Override
    @LogAnnotation(name="注销用户")
    public void updateUser(User user) {
        ud.updateData(user);
    }

    @Override
    public PageDTO<User> queryAllDJ(Integer page, Integer rows) {
        Integer totalCount = ud.findTotalCountDJ();
        List<User> users = ud.queryAllDJ(page, rows);
        PageDTO<User> p = new PageDTO<User>();
        p.setTotal(totalCount);
        p.setRows(users);
        return p;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<UserVO> queryGroupMan() {
        return ud.queryGroupMan();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<UserVO> queryGroupFemale() {
        return ud.queryGroupFemale();
    }
}
