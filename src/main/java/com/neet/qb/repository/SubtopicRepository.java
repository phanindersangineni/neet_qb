package com.neet.qb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.neet.qb.model.SubTopic;

public interface SubtopicRepository extends MongoRepository<SubTopic, String> {
	
   List<SubTopic> findById(String id);
   
   List<SubTopic> findByTopicId(String topicId);
   
   
   

}
