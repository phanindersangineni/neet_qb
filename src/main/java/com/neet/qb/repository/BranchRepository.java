package com.neet.qb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.neet.qb.model.Branch;

public interface BranchRepository extends MongoRepository<Branch, String>  {
	
	List<Branch> findByCenterId(String centerId);

}
