package com.baizhi.service.impl;

import com.baizhi.dao.CategoryDao;
import com.baizhi.entity.Category;
import com.baizhi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao cd;

    public void setCd(CategoryDao cd) {
        this.cd = cd;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Category> findAll() {
        return cd.findAll();
    }
}
