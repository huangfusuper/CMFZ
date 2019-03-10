package com.baizhi.service.impl;

import com.baizhi.aop.LogAnnotation;
import com.baizhi.dao.GuruDao;
import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("guruService")
@Transactional
public class GuruServiceImpl implements GuruService {
    @Autowired
    private GuruDao gd;

    public void setGd(GuruDao gd) {
        this.gd = gd;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Guru> findAll() {
        return gd.findAll();
    }

    @Override
    @LogAnnotation(name="增加上师")
    public void addData(Guru guru) {
        gd.addData(guru);
    }

    @Override
    @LogAnnotation(name="修改上师")
    public void updateData(Guru t) {
        gd.updateData(t);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Guru queryOneGuru(String id) {
        return gd.queryOneGuru(id);
    }
}
