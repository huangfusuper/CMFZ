package com.baizhi.dao;

import com.baizhi.entity.Guru;

import java.util.List;

public interface GuruDao extends BackDao<Guru> {
    //查询上师详情
    Guru queryOneGuru(String id);
}
