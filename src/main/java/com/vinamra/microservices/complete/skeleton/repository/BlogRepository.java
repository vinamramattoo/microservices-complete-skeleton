package com.vinamra.microservices.complete.skeleton.repository;

import com.vinamra.microservices.complete.skeleton.dao.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog,Integer> {
}
