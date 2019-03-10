package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.entity.Children;
import com.baizhi.service.ChildrenService;
import com.baizhi.utils.FileUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

@Controller
@RequestMapping("children")
public class ChildrenController {
    @Autowired
    private ChildrenService cs;

    public void setCs(ChildrenService cs) {
        this.cs = cs;
    }

    @RequestMapping("ChildrenUpload")
    @ResponseBody
    public void ChildrenUpload(@RequestParam("file")MultipartFile file, String id, HttpServletRequest request){
        System.out.println(file + id);
        //获取文件真实姓名
        String name = file.getOriginalFilename();
        //拼接随机id
        String fileName = UUID.randomUUID().toString().replace("-", "")+name;
        //上传路径
        String strDirPath = request.getSession().getServletContext().getRealPath("/");
        String path = strDirPath+"main/mp4/";
        //写入数据库
        Children c = new Children();
        Album a = new Album();
        a.setId(id);
        c.setId(UUID.randomUUID().toString().replace("-", ""));
        c.setAlbum(a);
        c.setLength("30分钟");
        c.setUrl(fileName);
        c.setSize(file.getSize()+"");
        c.setName(name);
        cs.addData(c);
        //上传
        try {
            FileUtil.uploadFile(file.getBytes(), path, fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @RequestMapping("downloadFile")
    public ResponseEntity<byte[]> downloadFile(String url, String name, HttpServletResponse response, HttpServletRequest request) throws IOException {
        //设置文件路径
        String strDirPath = request.getSession().getServletContext().getRealPath("/");
        File file = new File(strDirPath+"main/mp4/"+url);
        File outFile = new File("C:/Users/皇甫/Desktop/"+name);
        HttpHeaders headers = new HttpHeaders();
        String downloadFileName = new String(name.getBytes("UTF-8"),"iso-8859-1");
        headers.setContentDispositionFormData("attachment", downloadFileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);
    }
}
