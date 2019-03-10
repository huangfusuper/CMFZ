package com.baizhi.service.impl;

import com.baizhi.aop.LogAnnotation;
import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao ad;

    public void setAd(AdminDao ad) {
        this.ad = ad;
    }

    @Override
    public Admin quieryOneByNameANDPassword(String name, String password) {
        return ad.findOneByNameAndPassword(name,password);
    }

    @Override
    @LogAnnotation(name="修改注销管理员")
    public void remove(String id) {
        ad.removeOneById(id);
    }

    @Override
    @LogAnnotation(name="修改管理员密码")
    public void updatePassword(Admin admin) {
        ad.updateData(admin);
    }

    @Override
    @LogAnnotation(name="增加修改管理员")
    public void addAdmin(Admin admin) {
        ad.addData(admin);
    }
}
