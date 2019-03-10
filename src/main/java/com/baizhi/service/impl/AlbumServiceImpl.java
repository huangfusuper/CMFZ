package com.baizhi.service.impl;

import com.baizhi.aop.LogAnnotation;
import com.baizhi.dao.AlbumDao;
import com.baizhi.dto.PageDTO;
import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("albumService")
@Transactional
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDao ad;

    public void setAd(AlbumDao ad) {
        this.ad = ad;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Album> findAll() {
        return ad.findAll();
    }

    @Override
    @LogAnnotation(name="增加专辑")
    public void addAlbum(Album album) {
        ad.addData(album);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Album findOne(String id) {
        return ad.findOneByID(id);
    }
}
