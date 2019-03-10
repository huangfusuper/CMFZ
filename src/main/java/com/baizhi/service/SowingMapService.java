package com.baizhi.service;

import com.baizhi.dto.PageDTO;
import com.baizhi.entity.SowingMap;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SowingMapService {
    //查询所有并分页
    PageDTO finAllPage(Integer page, Integer rows);
    //添加数据
    void addData(SowingMap sowingMap);
    //修改数据
    void updateData(SowingMap sowingMap);
    //删除数据
    void removeOneById(String id);
}
