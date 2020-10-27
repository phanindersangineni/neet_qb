package com.neet.qb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.neet.qb.model.Topic;

public interface TopicRepository extends MongoRepository<Topic, String> {
	
	List<Topic> findById(String id);
	
	List<Topic> findBySubjectId(String subjectId);
	
	

}
