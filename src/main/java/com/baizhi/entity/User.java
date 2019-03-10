package com.baizhi.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
    private String id;
    private String userName;
    private String password;
    private String name;
    private String nickName;
    private String sex;
    private Integer level;
    private Date time;
    private String address;
    private String imgPath;
    private String sign;
    private Guru guru;
    private List<Lesson> lessons = new ArrayList<Lesson>();

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", sex='" + sex + '\'' +
                ", level=" + level +
                ", time=" + time +
                ", address='" + address + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", sign='" + sign + '\'' +
                ", guru=" + guru +
                ", lessons=" + lessons +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Guru getGuru() {
        return guru;
    }

    public void setGuru(Guru guru) {
        this.guru = guru;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public User(String id, String userName, String password, String name, String nickName, String sex, Integer level, Date time, String address, String imgPath, String sign, Guru guru, List<Lesson> lessons) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.nickName = nickName;
        this.sex = sex;
        this.level = level;
        this.time = time;
        this.address = address;
        this.imgPath = imgPath;
        this.sign = sign;
        this.guru = guru;
        this.lessons = lessons;
    }

    public User() {
    }
}
