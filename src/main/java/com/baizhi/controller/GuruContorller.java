package com.baizhi.controller;

import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
import com.baizhi.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("guru")
public class GuruContorller {
    @Autowired
    private GuruService gs;

    public void setGs(GuruService gs) {
        this.gs = gs;
    }
    //查所有
    @RequestMapping("findAll")
    @ResponseBody
    public List<Guru> findAll(){
        return gs.findAll();
    }
    //修改
    @RequestMapping("update")
    @ResponseBody
    public void update(Guru guru){
        gs.updateData(guru);
    }
    //添加
    @RequestMapping("addguru")
    @ResponseBody
    public void addguru(Guru guru, MultipartFile file, HttpServletRequest request) throws Exception {
        guru.setId(UUID.randomUUID().toString().replace("-", ""));
        //获取文件名
        String name = file.getOriginalFilename();
        //设置最终上师头像文件名
        String fileName = UUID.randomUUID().toString().replace("-", "")+name;
        //设置文件全路径
        String strDirPath = request.getSession().getServletContext().getRealPath("/");
        String path = strDirPath+"main/img/upload/";
        guru.setGuruImgPath(fileName);
        gs.addData(guru);
        //上传文件
        FileUtil.uploadFile(file.getBytes(), path, fileName);

    }
    //查单个
    @RequestMapping("findOne")
    @ResponseBody
    public Guru findOne(String id){
        return gs.queryOneGuru(id);
    }
}
