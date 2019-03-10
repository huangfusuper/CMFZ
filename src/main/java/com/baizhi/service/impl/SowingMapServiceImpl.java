package com.baizhi.service.impl;

import com.baizhi.aop.LogAnnotation;
import com.baizhi.dao.SowingMapDao;
import com.baizhi.dto.PageDTO;
import com.baizhi.entity.SowingMap;
import com.baizhi.service.SowingMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("sowingMapService")
@Transactional
public class SowingMapServiceImpl implements SowingMapService {
    @Autowired
    private SowingMapDao sd;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public PageDTO finAllPage(Integer page, Integer rows) {
        List<SowingMap> maps = sd.finAllPage(page, rows);
        Integer total = sd.findTotalCount();
        PageDTO pd = new PageDTO(total,maps);
        return pd;
    }


    @Override
    @LogAnnotation(name="增加轮播图")
    public void addData(SowingMap sowingMap) {
        sd.addData(sowingMap);
    }

    @Override
    @LogAnnotation(name="修改轮播图")
    public void updateData(SowingMap sowingMap) {
        sd.updateData(sowingMap);
    }

    @Override
    @LogAnnotation(name="删除轮播图")
    public void removeOneById(String id) {
        sd.removeOneById(id);
    }
}
