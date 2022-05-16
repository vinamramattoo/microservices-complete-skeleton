package com.vinamra.microservices.complete.skeleton.service;

import com.vinamra.microservices.complete.skeleton.dao.Blog;
import com.vinamra.microservices.complete.skeleton.dao.Comment;
import com.vinamra.microservices.complete.skeleton.dao.Topic;
import com.vinamra.microservices.complete.skeleton.exception.ResourceNotFoundException;
import com.vinamra.microservices.complete.skeleton.repository.BlogRepository;
import com.vinamra.microservices.complete.skeleton.repository.CommentRepository;
import com.vinamra.microservices.complete.skeleton.repository.TopicRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger log = LoggerFactory.getLogger(ApplicationService.class);


    public Topic createTopicObject(Topic topic) {
        return topicRepository.save(topic);
    }

    public Blog createBlogObject(Blog blog,Topic topic) throws ResourceNotFoundException {
        log.info("The current id for topic is : "+ topic.getId());
        Topic currTopic = topicRepository.findById(topic.getId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Topic not found with this ID :: %s", topic.getId())));
        blog.setTopic(currTopic);
        return blogRepository.save(blog);
    }


    public Comment createCommentObject(Comment comment,Blog blog) throws ResourceNotFoundException {
        Blog currBlog = blogRepository.findById(blog.getId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Blog not found with this ID :: %s", comment.getBlog().getId())));
        comment.setBlog(currBlog);
        return commentRepository.save(comment);
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

    public void deleteTopic(int id) throws ResourceNotFoundException {
        Topic currTopic = topicRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Topic not found with this ID :: %s", id)));
        topicRepository.delete(currTopic);
    }

    public void deleteBlog(int id) throws ResourceNotFoundException {
        Blog currBlog = blogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Topic not found with this ID :: %s", id)));
        blogRepository.delete(currBlog);
    }

    public void deleteComment(int id) throws ResourceNotFoundException {
        Comment currComment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Topic not found with this ID :: %s", id)));
        commentRepository.delete(currComment);
    }

    public Topic updateTopic(int id,Topic topic) throws ResourceNotFoundException {
        Topic currTopic = topicRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Topic not found with this ID :: %s", id)));
        currTopic.setName(topic.getName());
        return topicRepository.save(currTopic);
    }

    public Blog updateBlog(int id,Blog blog) throws ResourceNotFoundException {
        Blog currBlog = blogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Topic not found with this ID :: %s", id)));
        currBlog.setName(blog.getName());
        currBlog.setContent(blog.getContent());
        return blogRepository.save(currBlog);
    }

    public Comment updateComment(int id,Comment comment) throws ResourceNotFoundException {
        Comment currComment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Topic not found with this ID :: %s", id)));

        currComment.setContent(comment.getContent());
        return commentRepository.save(currComment);
    }
}
