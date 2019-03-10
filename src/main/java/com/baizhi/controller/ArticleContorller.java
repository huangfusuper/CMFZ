package com.baizhi.controller;

import com.baizhi.entity.Article;
import com.baizhi.service.ArticleService;
import com.baizhi.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * @author 皇甫
 * @since JDK9.0
 *
 * */
@Controller
@RequestMapping("article")
public class ArticleContorller {
    @Autowired
    private ArticleService as;

    public void setAs(ArticleService as) {
        this.as = as;
    }

    /**
     * @param file  上传的文件
     * */
    @RequestMapping("addDate")
    @ResponseBody
    public void addDate(MultipartFile file, Article a, HttpServletRequest request) throws Exception {
        String name = file.getOriginalFilename();
        String fileName = UUID.randomUUID().toString().replace("-", "")+name;
        String strDirPath = request.getSession().getServletContext().getRealPath("/");
        String path = strDirPath+"main/img/uploadtext/";

        a.setArUrl(fileName);
        a.setDate(new Date());
        a.setId(UUID.randomUUID().toString().replace("-", ""));
        as.addData(a);

        FileUtil.uploadFile(file.getBytes(), path, fileName);
    }
}
