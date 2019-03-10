package com.baizhi.service.impl;

import com.baizhi.dao.LogDao;
import com.baizhi.dto.PageDTO;
import com.baizhi.entity.Admin;
import com.baizhi.entity.Log;
import com.baizhi.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("logService")
@Transactional
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao ld;

    public void setLd(LogDao ld) {
        this.ld = ld;
    }

    @Override
    public void addData(Log log) {
        ld.addData(log);
    }

    @Override
    public PageDTO finAllPage(Integer page, Integer rows) {
        List<Log> logs = ld.finAllPage(page, rows);
        Integer totalCount = ld.findTotalCount();
        PageDTO<Log> pageDTO = new PageDTO<>(totalCount, logs);
        return pageDTO;
    }
}
