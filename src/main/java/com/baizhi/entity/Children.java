package com.baizhi.entity;
/*
* 章节列表
* */
public class Children {
    private String id;
    private String name;
    private String size;
    private String length;
    private String url;

    private Album album;

    @Override
    public String toString() {
        return "Children{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", length='" + length + '\'' +
                ", url='" + url + '\'' +
                ", album=" + album +
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Children(String id, String name, String size, String length, String url, Album album) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.length = length;
        this.url = url;
        this.album = album;
    }

    public Children() {
    }
}
