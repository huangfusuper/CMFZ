package com.baizhi.service;

import com.baizhi.entity.Guru;

import java.util.List;

public interface GuruService {
    //查询所有
    List<Guru> findAll();
    //添加数据
    void addData(Guru guru);
    //修改数据
    void updateData(Guru t);
    //查询上师详情
    Guru queryOneGuru(String id);

}
