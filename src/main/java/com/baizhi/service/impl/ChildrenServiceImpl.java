package com.baizhi.service.impl;

import com.baizhi.aop.LogAnnotation;
import com.baizhi.dao.ChildrenDao;
import com.baizhi.entity.Children;
import com.baizhi.service.ChildrenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("childrenService")
@Transactional
public class ChildrenServiceImpl implements ChildrenService {
    @Autowired
    private ChildrenDao cd;

    public void setCd(ChildrenDao cd) {
        this.cd = cd;
    }

    @Override
    @LogAnnotation(name="增加章节")
    public void addData(Children c) {
        cd.addData(c);
    }
}
