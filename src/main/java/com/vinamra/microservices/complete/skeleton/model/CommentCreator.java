package com.vinamra.microservices.complete.skeleton.model;

import com.vinamra.microservices.complete.skeleton.dao.Blog;
import com.vinamra.microservices.complete.skeleton.dao.Comment;

public class CommentCreator {
    private Comment comment;
    private Blog blog;

    public CommentCreator() {
    }

    public CommentCreator(Comment comment, Blog blog) {
        this.comment = comment;
        this.blog = blog;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    @Override
    public String toString() {
        return "CommentCreator{" +
                "comment=" + comment +
                ", blog=" + blog +
                '}';
    }
}
