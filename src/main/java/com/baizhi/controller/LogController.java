package com.baizhi.controller;

import com.baizhi.dto.PageDTO;
import com.baizhi.entity.Log;
import com.baizhi.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 皇甫
 */
@RestController
@RequestMapping("log")
public class LogController {
    @Autowired
    private LogService logService;
    @RequestMapping("findAdd")
    public PageDTO<Log> findAdd(Integer page,Integer rows){
        return logService.finAllPage(page, rows);
    }
}
