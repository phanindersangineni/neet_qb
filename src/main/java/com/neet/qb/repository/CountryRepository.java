package com.neet.qb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.neet.qb.model.Country;

public interface CountryRepository extends MongoRepository<Country, String> {
	
	List<Country> findByCountryname(String countryname);

}
