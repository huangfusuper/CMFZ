package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Article {
    private String id;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date date;
    private String detalis;
    private String arUrl;
    private Guru guru;

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", detalis='" + detalis + '\'' +
                ", arUrl='" + arUrl + '\'' +
                ", guru=" + guru +
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDetalis() {
        return detalis;
    }

    public void setDetalis(String detalis) {
        this.detalis = detalis;
    }

    public String getArUrl() {
        return arUrl;
    }

    public void setArUrl(String arUrl) {
        this.arUrl = arUrl;
    }

    public Guru getGuru() {
        return guru;
    }

    public void setGuru(Guru guru) {
        this.guru = guru;
    }

    public Article(String id, String name, Date date, String detalis, String arUrl, Guru guru) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.detalis = detalis;
        this.arUrl = arUrl;
        this.guru = guru;
    }

    public Article() {
    }
}
