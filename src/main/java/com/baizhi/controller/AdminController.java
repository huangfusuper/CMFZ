package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService as;

    public void setAs(AdminService as) {
        this.as = as;
    }

    //登陆
    @RequestMapping("login")
    public String login(String name, String password, HttpSession session){
        Admin admin = as.quieryOneByNameANDPassword(name, password);
        if(admin==null){
            return "redirect:/admin/login.jsp";
        }else{
            session.setAttribute("admin",admin);
            return "redirect:/main/main.jsp";
        }
    }
    //注册
    @RequestMapping("addAdmin")
    @ResponseBody
    public String addAdmin(Admin admin){
        try {
            as.addAdmin(admin);
            return "y";
        }catch (Exception e){
            e.printStackTrace();
            return "n";
        }
    }
    //修改密码
    @RequestMapping("update")
    @ResponseBody
    public void update(Admin admin){
        as.updatePassword(admin);
    }
    //安全退出
    @RequestMapping("exitAdmin")
    public String exitAdmin(HttpSession session){
        session.removeAttribute("admin");
        return "redirect:/admin/login.jsp";
    }
}
