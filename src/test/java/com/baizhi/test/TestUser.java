package com.baizhi.test;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.dao.UserDao;
import com.baizhi.dto.PageDTO;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.vo.UserVO;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestUser {
    @Autowired
    private UserDao ud;
    @Autowired
    private UserService us;

    public void setUd(UserDao ud) {
        this.ud = ud;
    }

    @Test
    public void test1(){
        List<User> users = ud.finAllPage(1, 5);
    }
    @Test
    public void test3(){
        List<User> users = ud.queryAllDJ(1, 5);
        System.out.println(users);
    }
    @Test
    public void test2(){
        User user = new User();
        user.setId("1");
        user.setLevel(0);
        ud.updateData(user);
    }
    @Test
    public void test4(){
        Integer totalCountDJ = ud.findTotalCountDJ();
        System.out.println(totalCountDJ);
    }
    @Test
    public void test5(){
        PageDTO<User> userPageDTO = us.queryAllDJ(1, 5);
        List<User> rows = userPageDTO.getRows();
        for (User row : rows) {
            System.out.println(row.getName());
        }
    }

    @Test
    public void test6(){
        JSONObject j = new JSONObject();
        j.put("name", "上海");
        j.put("value", 100);
        String s = JSONObject.toJSONString(j);
        System.out.println(s);
    }
    @Test
    public void test7(){
        List<UserVO> userVOS = us.queryGroupMan();
        String s = JSONObject.toJSONString(userVOS);
        System.out.println(s);
    }
    @Test
    public void test8(){
        List<String> s = TestUser.fileList("C:/Users/皇甫/Desktop/11.txt");
        List<String> names = TestUser.fileList("C:/Users/皇甫/Desktop/22.txt");
        List<String> userNames = TestUser.fileList("C:/Users/皇甫/Desktop/33.txt");
        List<String> sexs = new ArrayList<String>();
        sexs.add("男");
        sexs.add("女");
        for(int i=0;i<10000;i++){
            int sr = (int)(Math.random()*s.size());
            int namesr = (int)(Math.random()*names.size());
            int userNamesr = (int)(Math.random()*userNames.size());
            int sexr = (int)(Math.random()*sexs.size());
            String uuid = UUID.randomUUID().toString().replace("-", "");
            User user = new User();
            user.setId(uuid);
            user.setLevel(1);
            user.setName(names.get(namesr));
            user.setPassword("123456");
            user.setUserName(userNames.get(userNamesr));
            user.setAddress(s.get(sr));
            user.setImgPath("bfjhksdkfhjskdhfjks");
            user.setTime(new Date());
            user.setNickName("hahaha");
            user.setSign("听天由命");
            user.setSex(sexs.get(sexr));
            ud.addDataAll(user);
        }

        System.out.println("插入成功");
    }

    public static List<String> fileList(String path) {
        File input = new File(path);
        InputStream is = null;
        InputStreamReader fis = null;
        BufferedReader bis = null;
        List<String> list = new ArrayList<String>();
        try {
            is = new FileInputStream(input);
            fis = new InputStreamReader(is);
            bis = new BufferedReader(fis);
            String str = bis.readLine();
            while (str !=null){
                list.add(str);
                str = bis.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
