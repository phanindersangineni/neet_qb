package com.neet.qb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.neet.qb.model.Features;

public interface FeatureRepository  extends MongoRepository<Features, String>{
	
	List<Features> findById(String id);
	

}
