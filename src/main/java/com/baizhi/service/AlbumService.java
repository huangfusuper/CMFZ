package com.baizhi.service;

import com.baizhi.dto.PageDTO;
import com.baizhi.entity.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlbumService {
    //查询所有 分页
    List<Album> findAll();
    //添加专辑
    void addAlbum(Album album);
    //查询一个
    Album findOne(String id);
}
