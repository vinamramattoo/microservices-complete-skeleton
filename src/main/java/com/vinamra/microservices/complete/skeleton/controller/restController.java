package com.vinamra.microservices.complete.skeleton.controller;

import com.vinamra.microservices.complete.skeleton.dao.Blog;
import com.vinamra.microservices.complete.skeleton.dao.Comment;
import com.vinamra.microservices.complete.skeleton.dao.Topic;
import com.vinamra.microservices.complete.skeleton.model.BlogRepository;
import com.vinamra.microservices.complete.skeleton.model.CommentRepository;
import com.vinamra.microservices.complete.skeleton.model.TopicRepository;
import com.vinamra.microservices.complete.skeleton.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class restController {
    @Autowired
    ApplicationService service;


//    RestApi ===========================


    //    Creation
    @PostMapping("/topic")
    public Topic createTopic(@RequestBody Topic topic) {
        return service.createTopicObject(topic);
    }

    @PostMapping(BlogPaths.CREATE)
    public Blog createBlog(@RequestBody Blog blog) {
        return service.createBlogObject(blog);
    }

    @PostMapping("/comment")
    public Comment createComment(@RequestBody Comment comment) {
        return service.createCommentObject(comment);
    }

//get

    @GetMapping("/topic")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Topic> getAllTopics() {
        return service.getAllTopics();
    }

    @GetMapping(BlogPaths.GET_ITEMS)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Blog> getAllBlogs() {
        return service.getAllBlogs();
    }

    @GetMapping("/comment")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Comment> getAllComments() {
        return service.getAllComments();
    }
}
