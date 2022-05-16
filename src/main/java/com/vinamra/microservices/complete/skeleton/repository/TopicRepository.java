package com.vinamra.microservices.complete.skeleton.repository;

import com.vinamra.microservices.complete.skeleton.dao.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic,Integer> {
}
