package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.TestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("testUser")
public class UserInterfaceController {
    @Autowired
    private TestUserService ts;

    @RequestMapping("login")
    @ResponseBody
    public void login(String userName,String password){
        User login = ts.login(userName, password);
        if(login!=null){
            System.out.println("OJBK");
        }else{
            System.out.println("滚犊子");
        }
    }

    @RequestMapping("zhuce")
    @ResponseBody
    public void zhuce(User user){
        ts.zhuce(user);
    }
}
