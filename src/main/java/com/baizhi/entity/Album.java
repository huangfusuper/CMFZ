package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
* 专辑列表
*
* */
public class Album {
    private String id;
    private String name;//专辑标题
    private String pubName;//专辑发布人
    private String brodcastname;//波音姓名
    private Integer count;
    private String bries;//详细信息
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date createTime;
    private String imgPath;
    private List<Children> children = new ArrayList<Children>();

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pubName='" + pubName + '\'' +
                ", brodcastname='" + brodcastname + '\'' +
                ", count=" + count +
                ", bries='" + bries + '\'' +
                ", createTime=" + createTime +
                ", imgPath='" + imgPath + '\'' +
                ", children=" + children +
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

    public String getPubName() {
        return pubName;
    }

    public void setPubName(String pubName) {
        this.pubName = pubName;
    }

    public String getBrodcastname() {
        return brodcastname;
    }

    public void setBrodcastname(String brodcastname) {
        this.brodcastname = brodcastname;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getBries() {
        return bries;
    }

    public void setBries(String bries) {
        this.bries = bries;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public List<Children> getChildren() {
        return children;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }

    public Album(String id, String name, String pubName, String brodcastname, Integer count, String bries, Date createTime, String imgPath, List<Children> children) {
        this.id = id;
        this.name = name;
        this.pubName = pubName;
        this.brodcastname = brodcastname;
        this.count = count;
        this.bries = bries;
        this.createTime = createTime;
        this.imgPath = imgPath;
        this.children = children;
    }

    public Album() {
    }
}
