package com.vinamra.microservices.complete.skeleton.model;

import com.vinamra.microservices.complete.skeleton.dao.Blog;
import com.vinamra.microservices.complete.skeleton.dao.Topic;

public class BlogCreator {
    private Blog blog;
    private Topic topic;

    public BlogCreator() {
    }

    public BlogCreator(Blog blog, Topic topic) {
        this.blog = blog;
        this.topic = topic;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "BlogCreator{" +
                "blog=" + blog +
                ", topic=" + topic +
                '}';
    }
}
