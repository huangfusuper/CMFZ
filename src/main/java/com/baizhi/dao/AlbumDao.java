package com.baizhi.dao;

import com.baizhi.entity.Album;

public interface AlbumDao extends BackDao<Album> {
    //添加专辑
    //查询所有分页
    //查看单个
    Album findOneByID(String id);
}
