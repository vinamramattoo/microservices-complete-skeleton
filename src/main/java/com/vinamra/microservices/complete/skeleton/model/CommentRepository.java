package com.vinamra.microservices.complete.skeleton.model;

import com.vinamra.microservices.complete.skeleton.dao.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Integer> {
}
