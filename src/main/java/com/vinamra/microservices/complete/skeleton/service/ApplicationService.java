package com.vinamra.microservices.complete.skeleton.service;

import com.vinamra.microservices.complete.skeleton.dao.Blog;
import com.vinamra.microservices.complete.skeleton.dao.Comment;
import com.vinamra.microservices.complete.skeleton.dao.Topic;
import com.vinamra.microservices.complete.skeleton.model.BlogRepository;
import com.vinamra.microservices.complete.skeleton.model.CommentRepository;
import com.vinamra.microservices.complete.skeleton.model.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {

    @Autowired
    TopicRepository topicRepository;
    @Autowired
    BlogRepository blogRepository;

    @Autowired
    CommentRepository commentRepository;





    public Topic createTopicObject(Topic topic){
        return topicRepository.save(topic);
    }
    public Blog createBlogObject(Blog blog){
        Optional<Topic> tempTopic = topicRepository.findById(blog.getTopic().getId());
        if (tempTopic.isPresent()) {
            Topic topic = tempTopic.get();
            blog.setTopic(topic);
            return blogRepository.save(blog);
        }
        else {
            throw new RuntimeException("Topic not found");
        }
    }


    public Comment createCommentObject(Comment comment){
        Optional<Blog> tempBlog = blogRepository.findById(comment.getBlog().getId());
        if (tempBlog.isPresent()) {
            Blog blog = tempBlog.get();
            comment.setBlog(blog);
            return commentRepository.save(comment);
        }
        else {
            throw new RuntimeException("Blog not found");
        }
    }

    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }
}
