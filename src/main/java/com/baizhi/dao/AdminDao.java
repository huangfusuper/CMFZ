package com.baizhi.dao;

import com.baizhi.entity.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminDao extends BackDao<Admin> {
    //查一个
    Admin findOneByNameAndPassword(@Param("name") String name, @Param("password") String password);
}
