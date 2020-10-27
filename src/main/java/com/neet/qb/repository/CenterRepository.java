package com.neet.qb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.neet.qb.model.Center;

public interface CenterRepository extends MongoRepository<Center, String> {
	
	List<Center> findByStateId(String stateId);
	

}
