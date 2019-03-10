package com.baizhi.test;

import com.baizhi.dao.ArticleDao;
import com.baizhi.entity.Article;
import com.baizhi.entity.Guru;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ArticleTest {
    @Autowired
    private ArticleDao ad;

    public void setAd(ArticleDao ad) {
        this.ad = ad;
    }

    @Test
    public void test1(){
        Guru guru = new Guru();
        guru.setId("1");
        Article article = new Article("1", "大大", new Date(), "哈","sdasdas", guru);
        ad.addData(article);
    }
}
