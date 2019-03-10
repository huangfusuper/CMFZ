package com.baizhi.controller;

import com.baizhi.entity.Category;
import com.baizhi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryService cs;

    public void setCs(CategoryService cs) {
        this.cs = cs;
    }

    @RequestMapping("findAll")
    @ResponseBody
    public List<Category> findAll(){
        return cs.findAll();
    }

}
