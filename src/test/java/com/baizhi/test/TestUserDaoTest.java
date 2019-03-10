package com.baizhi.test;

import com.baizhi.dao.TestUserDao;
import com.baizhi.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.UUID;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestUserDaoTest {
    @Autowired
    private TestUserDao ts;

    public void setTs(TestUserDao ts) {
        this.ts = ts;
    }

    @Test
    public void test1(){
        User login = ts.login("qwert", "hjasdhf");
        System.out.println(login);
    }

    @Test
    public void test2(){
        User user = new User();
        user.setId(UUID.randomUUID().toString().replace("-", ""));
        user.setSex("男");
        user.setSign("ahfjkdahsjkdhas");
        user.setNickName("当当");
        user.setTime(new Date());
        user.setImgPath("bhdjashjds");
        user.setAddress("打着形成");
        user.setUserName("qwert");
        user.setPassword("hjasdhf");
        ts.zhuce(user);
    }
}
