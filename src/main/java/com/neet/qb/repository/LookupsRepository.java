package com.neet.qb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.neet.qb.model.Lookups;

public interface LookupsRepository extends MongoRepository<Lookups, String> {
	
	@Query("{ 'code' : ?0 }") 
	List<Lookups> findByLookupCode(String code);	

}
