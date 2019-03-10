package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class SowingMap {
    private String id;
    private String name;
    private Integer level;
    private String url;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date date;

    @Override
    public String toString() {
        return "SowingMap{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", url='" + url + '\'' +
                ", date=" + date +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public SowingMap(String id, String name, Integer level, String url, Date date) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.url = url;
        this.date = date;
    }

    public SowingMap() {
    }
}
