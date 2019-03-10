package com.baizhi.test;

import com.baizhi.dao.SowingMapDao;
import com.baizhi.entity.SowingMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SowingMapTest {

    @Autowired
    private SowingMapDao sd;

    @Test
    public void test1(){
        List<SowingMap> all = sd.finAllPage(1,5);
        for (SowingMap sowingMap : all) {
            System.out.println(sowingMap.getName());
        }
    }
    @Test
    public void test2(){
        Integer totalCount = sd.findTotalCount();
        System.out.println(totalCount);
    }
}
