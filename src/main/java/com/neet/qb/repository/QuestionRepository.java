package com.neet.qb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.neet.qb.model.Question;

public interface QuestionRepository extends MongoRepository<Question, String> {
	
	List<Question> findByBranchid(String branchid);
	
	List<Question> findByCenterid(String centerid);
	
	List<Question> findById(String id);
	
	List<Question> findByUserid(String userid);
	
	
	

	

}
