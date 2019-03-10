package com.baizhi.test;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AdminTest {
    @Autowired
    private AdminDao ad;

    public void setAd(AdminDao ad) {
        this.ad = ad;
    }

    @Test
    public void test1(){
        ad.addData(new Admin(UUID.randomUUID().toString().replace("-",""),"baizhi","123456"));
    }

    @Test
    public void test2(){
        Admin admin = ad.findOneByNameAndPassword("baizhi", "123");
        System.out.println(admin);
    }

    @Test
    public void test3(){
        Admin a = new Admin();
        a.setId("0b606d7a4eac4c0ca9863a959cfac106");
        a.setPassword("123");
        ad.updateData(a);
    }
    @Test
    public void test4(){
        ad.removeOneById("0b606d7a4eac4c0ca9863a959cfac106");
    }
}
