package com.baizhi.service.impl;

import com.baizhi.aop.LogAnnotation;
import com.baizhi.dao.ArticleDao;
import com.baizhi.entity.Article;
import com.baizhi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("articleService")
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao ad;

    public void setAd(ArticleDao ad) {
        this.ad = ad;
    }

    @Override
    @LogAnnotation(name="增加文章")
    public void addData(Article a) {
        ad.addData(a);
    }
}
