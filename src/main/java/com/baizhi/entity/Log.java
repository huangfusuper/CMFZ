package com.baizhi.entity;

import java.util.Date;

public class Log {
    private Integer id;
    private String adminName;
    private Date opertionDate;
    private String opertionName;
    private String flag;

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", adminName='" + adminName + '\'' +
                ", opertionDate=" + opertionDate +
                ", opertionName='" + opertionName + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public Date getOpertionDate() {
        return opertionDate;
    }

    public void setOpertionDate(Date opertionDate) {
        this.opertionDate = opertionDate;
    }

    public String getOpertionName() {
        return opertionName;
    }

    public void setOpertionName(String opertionName) {
        this.opertionName = opertionName;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Log(Integer id, String adminName, Date opertionDate, String opertionName, String flag) {
        this.id = id;
        this.adminName = adminName;
        this.opertionDate = opertionDate;
        this.opertionName = opertionName;
        this.flag = flag;
    }

    public Log() {
    }
}
