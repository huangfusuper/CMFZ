package com.baizhi.controller;

import com.baizhi.dto.PageDTO;
import com.baizhi.entity.SowingMap;
import com.baizhi.service.SowingMapService;
import com.baizhi.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/sowingMap")
public class SowingMapController {
    @Autowired
    private SowingMapService ss;

    //查询全部分页
    @RequestMapping("findAllPage")
    @ResponseBody
    public PageDTO<SowingMap> findAllPage(Integer page,Integer rows){
        return ss.finAllPage(page,rows);
    }
    /**
     * springBoot文件上传注意事项
     * 1、页面form表单name属性必须和参数变量一致
     * 2、encotype必须为multipart/form-data
     * 3、请求方式必须为post
     * 4、如果是springmvc需要导入三个jar
     * @param file 上传文件对象;
     * @param request 获取路径
     *
     */
    //添加
    @RequestMapping("upload")
    @ResponseBody
    public void upload(@RequestParam("file") MultipartFile file ,HttpServletRequest request,String name) throws IOException {


        String contentType = file.getContentType();   //图片文件类型
        //文件url真实名字
        String fileName = UUID.randomUUID().toString().replace("-","")+file.getOriginalFilename();
        //文件存放路径
        String strDirPath = request.getSession().getServletContext().getRealPath("/");
        String filePath = strDirPath+"main/img/upload/";
        // 插入图片名称到数据库
        SowingMap s = new SowingMap();
        s.setId(UUID.randomUUID().toString().replace("-",""));
        s.setName(name);
        //文件上传初始状态全部为不展示
        s.setLevel(0);
        //文件路径
        s.setUrl(fileName);
        //文件上传时间
        s.setDate(new Date());
        ss.addData(s);

        //调用文件处理类FileUtil，处理文件，将文件写入指定位置
        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }


    //删除
    @RequestMapping("removeOneDataByID")
    @ResponseBody
    public void removeOneDataByID(String id,String fileName,HttpServletRequest request){
        ss.removeOneById(id);
        String strDirPath = request.getSession().getServletContext().getRealPath("/");
        File file= new File(strDirPath+"main/img/upload/"+fileName);
        //删除文件
        file.delete();
    }
    //修改
    @RequestMapping("updateData")
    @ResponseBody
    public void updateData(SowingMap s){
        ss.updateData(s);
    }
}
