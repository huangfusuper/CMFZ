package com.baizhi.entity;

import java.util.ArrayList;
import java.util.List;

public class Lesson {
    private String id;
    private String name;
    private User user;
    private List<Count> counts = new ArrayList<Count>();

    @Override
    public String toString() {
        return "Lesson{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", user=" + user +
                ", counts=" + counts +
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Count> getCounts() {
        return counts;
    }

    public void setCounts(List<Count> counts) {
        this.counts = counts;
    }

    public Lesson(String id, String name, User user, List<Count> counts) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.counts = counts;
    }

    public Lesson() {
    }
}
