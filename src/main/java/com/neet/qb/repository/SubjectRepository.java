package com.neet.qb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.neet.qb.model.Subject;

public interface SubjectRepository extends MongoRepository<Subject, String> {
	
	List<Subject> findById(String id);
	

}
