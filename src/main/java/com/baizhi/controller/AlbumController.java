package com.baizhi.controller;

import com.baizhi.dto.PageDTO;
import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import com.baizhi.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("album")
public class AlbumController {
    @Autowired
    private AlbumService as;

    public void setAs(AlbumService as) {
        this.as = as;
    }

    //查询所有专辑分页

    @RequestMapping("findAllPage")
    @ResponseBody
    public List<Album> findAllPage(Integer page, Integer rows){
        return as.findAll();
    }
    //查询一个专辑
    @RequestMapping("findOneAlbum")
    @ResponseBody
    public Album findOneAlbum(String id){
        return as.findOne(id);
    }
    //添加一个专辑
    @RequestMapping("addAlbumAndUpload")
    @ResponseBody
    public void addOneData(Album a, @RequestParam("file")MultipartFile file, HttpSession session, HttpServletRequest request){
        //获取文件名
        String name = file.getOriginalFilename();
        //设置随即文件名
        String fileName = UUID.randomUUID().toString().replace("-", "")+name;
        String strDirPath = request.getSession().getServletContext().getRealPath("/");
        String url = strDirPath+"main/img/upload/";
        a.setId(UUID.randomUUID().toString().replace("-","" ));
        a.setCreateTime(new Date());
        a.setImgPath(fileName);
        as.addAlbum(a);
        try {
            FileUtil.uploadFile(file.getBytes(), url, fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
