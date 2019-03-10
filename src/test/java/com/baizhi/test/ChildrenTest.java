package com.baizhi.test;

import com.baizhi.dao.ChildrenDao;
import com.baizhi.entity.Album;
import com.baizhi.entity.Children;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ChildrenTest {
    @Autowired
    private ChildrenDao cd;

    public void setCd(ChildrenDao cd) {
        this.cd = cd;
    }

    @Test
    public void test1(){
        Album a = new Album();
        a.setId("01a563f22e0445769f8adbdd61a0428d");
        Children children = new Children(UUID.randomUUID().toString().replace("-", ""), "大悲咒第一级", "30M", "120分钟", "/D:", a);
        cd.addData(children);
    }
}
