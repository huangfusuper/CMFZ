package com.baizhi.service;

import com.baizhi.dto.PageDTO;
import com.baizhi.entity.Admin;
import com.baizhi.entity.Log;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * @author 皇甫
 */
public interface LogService {
    /**
     * 添加操作日志
     * @param log
     */
    void addData(Log log);

    /**
     * 查询所有日志
     * @param page
     * @param rows
     * @return
     */
    PageDTO finAllPage(Integer page,Integer rows);
}
