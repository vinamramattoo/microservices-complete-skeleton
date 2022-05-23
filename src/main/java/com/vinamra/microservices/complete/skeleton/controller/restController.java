package com.vinamra.microservices.complete.skeleton.controller;

import com.vinamra.microservices.complete.skeleton.controller.paths.BlogPaths;
import com.vinamra.microservices.complete.skeleton.controller.paths.CommentPaths;
import com.vinamra.microservices.complete.skeleton.controller.paths.TopicPaths;
import com.vinamra.microservices.complete.skeleton.dao.Blog;
import com.vinamra.microservices.complete.skeleton.dao.Comment;
import com.vinamra.microservices.complete.skeleton.dao.Topic;
import com.vinamra.microservices.complete.skeleton.exception.ResourceNotFoundException;
import com.vinamra.microservices.complete.skeleton.model.BlogCreator;
import com.vinamra.microservices.complete.skeleton.model.CommentCreator;
import com.vinamra.microservices.complete.skeleton.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class restController {
    @Autowired
    ApplicationService service;


    //    Creation
    @PostMapping(TopicPaths.CREATE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Topic createTopic(@Valid @RequestBody Topic topic) {
        return service.createTopicObject(topic);
    }

    @PostMapping(BlogPaths.CREATE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Blog createBlog(@Valid @RequestBody BlogCreator blogCreator) throws ResourceNotFoundException {
        return service.createBlogObject(blogCreator.getBlog(), blogCreator.getTopic());
    }

    @PostMapping(CommentPaths.CREATE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Comment createComment(@Valid @RequestBody CommentCreator comment) throws ResourceNotFoundException {
        return service.createCommentObject(comment.getComment(), comment.getBlog());
    }

    //get

    @GetMapping(TopicPaths.GET_ITEMS)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Topic> getAllTopics() {
        return service.getAllTopics();
    }

    @GetMapping(BlogPaths.GET_ITEMS)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Blog> getAllBlogs() {
        return service.getAllBlogs();
    }

    @GetMapping(CommentPaths.GET_ITEMS)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Comment> getAllComments() {
        return service.getAllComments();
    }

    //delete


    @DeleteMapping(TopicPaths.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteTopics(@PathVariable int id) throws ResourceNotFoundException {
        service.deleteTopic(id);
    }

    @DeleteMapping(BlogPaths.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteBlogs(@PathVariable int id) throws ResourceNotFoundException {
        service.deleteBlog(id);
    }

    @DeleteMapping(CommentPaths.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteComments(@PathVariable int id) throws ResourceNotFoundException {
        service.deleteComment(id);
    }

    //edit


    @PutMapping(TopicPaths.UPDATE)
    @ResponseStatus(value = HttpStatus.OK)
    public Topic updateTopics(@PathVariable int id, @RequestBody Topic topic) throws ResourceNotFoundException {
        return service.updateTopic(id, topic);
    }

    @PutMapping(BlogPaths.UPDATE)
    @ResponseStatus(value = HttpStatus.OK)
    public Blog updateBlogs(@PathVariable int id, @RequestBody Blog blog) throws ResourceNotFoundException {
        return service.updateBlog(id, blog);
    }

    @PutMapping(CommentPaths.UPDATE)
    @ResponseStatus(value = HttpStatus.OK)
    public Comment updateComments(@PathVariable int id, @RequestBody Comment comment) throws ResourceNotFoundException {
        return service.updateComment(id, comment);
    }

}
