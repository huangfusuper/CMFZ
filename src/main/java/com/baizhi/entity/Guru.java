package com.baizhi.entity;


import java.util.ArrayList;
import java.util.List;

public class Guru {
    private String id;
    private String name;
    private String aliasname;
    private String guruImgPath;
    private Integer level;
    private List<Article> children = new ArrayList<Article>();

    @Override
    public String toString() {
        return "Guru{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", aliasname='" + aliasname + '\'' +
                ", guruImgPath='" + guruImgPath + '\'' +
                ", level=" + level +
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

    public String getAliasname() {
        return aliasname;
    }

    public void setAliasname(String aliasname) {
        this.aliasname = aliasname;
    }

    public String getGuruImgPath() {
        return guruImgPath;
    }

    public void setGuruImgPath(String guruImgPath) {
        this.guruImgPath = guruImgPath;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public List<Article> getChildren() {
        return children;
    }

    public void setChildren(List<Article> children) {
        this.children = children;
    }

    public Guru(String id, String name, String aliasname, String guruImgPath, Integer level, List<Article> children) {
        this.id = id;
        this.name = name;
        this.aliasname = aliasname;
        this.guruImgPath = guruImgPath;
        this.level = level;
        this.children = children;
    }

    public Guru() {
    }
}
