package com.baizhi.controller;

import com.baizhi.dto.PageDTO;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService us;

    @RequestMapping("findAll")
    @ResponseBody
    public PageDTO<User> findAll(Integer page,Integer rows){
        return us.findAllPage(page, rows);
    }
    @RequestMapping("findAllDJ")
    @ResponseBody
    public PageDTO<User> findAllDJ(Integer page,Integer rows){
        return us.queryAllDJ(page, rows);
    }
    @RequestMapping("update")
    @ResponseBody
    public void updateUser(String id,Integer level){
        User user = new User();
        user.setId(id);
        user.setLevel(level);
        us.updateUser(user);
    }
    //男
    @RequestMapping("queryGroupMan")
    @ResponseBody
    public List<UserVO> queryGroupMan(){
        return us.queryGroupMan();
    }
    //女
    @RequestMapping("queryGroupFemale")
    @ResponseBody
    public List<UserVO> queryGroupFemale(){
        return us.queryGroupFemale();
    }

    @RequestMapping("customerExport")
    @ResponseBody
    public void customerExport(String titles,String values){
        System.out.println(titles);
        System.out.println(values);
    }
}
