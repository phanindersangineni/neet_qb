package com.neet.qb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.neet.qb.model.State;

public interface StateRepository extends MongoRepository<State, String> {
	
	 List<State> findByCountryId(String countryId);
}
