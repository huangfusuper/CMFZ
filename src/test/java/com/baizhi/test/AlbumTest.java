package com.baizhi.test;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AlbumTest {
    @Autowired
    private AlbumDao ad;

    @Test
    public void test1(){
        List<Album> albums = ad.findAll();
        for (Album album : albums) {
            System.out.println(album.getName());
        }
    }

    //添加专辑
    @Test
    public void test2(){
        Album a = new Album(UUID.randomUUID().toString().replace("-", ""),"聆听妙音" ,"菠萝啦上师" ,"皇甫科星" ,31 ,"挺好的" ,new Date(),"D:/haha" ,null);
        ad.addData(a);
    }

    //查看一个
    @Test
    public void test3(){
        Album one = ad.findOneByID("01a563f22e0445769f8adbdd61a0428d");
        System.out.println(one);
    }
}
