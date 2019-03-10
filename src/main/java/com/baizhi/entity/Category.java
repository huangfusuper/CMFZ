package com.baizhi.entity;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private Integer id;
    private String name;
    private String conCls;
    private Integer level;
    private String URL;
    private List<Category> categories = new ArrayList<Category>();

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", conCls='" + conCls + '\'' +
                ", level=" + level +
                ", URL='" + URL + '\'' +
                ", categories=" + categories +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConCls() {
        return conCls;
    }

    public void setConCls(String conCls) {
        this.conCls = conCls;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Category(Integer id, String name, String conCls, Integer level, String URL, List<Category> categories) {
        this.id = id;
        this.name = name;
        this.conCls = conCls;
        this.level = level;
        this.URL = URL;
        this.categories = categories;
    }

    public Category() {
    }
}
