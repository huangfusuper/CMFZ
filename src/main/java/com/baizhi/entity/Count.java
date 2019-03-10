package com.baizhi.entity;

public class Count {
    private String id;
    private String name;
    private Integer count;
    private Lesson lesson;

    @Override
    public String toString() {
        return "Count{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", lesson=" + lesson +
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Count(String id, String name, Integer count, Lesson lesson) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.lesson = lesson;
    }

    public Count() {
    }
}
