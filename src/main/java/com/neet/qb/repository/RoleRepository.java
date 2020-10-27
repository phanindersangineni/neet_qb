package com.neet.qb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.neet.qb.model.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
	
	List<Role> findById(String id);
	List<Role> findByCode(String code);
	
	

}
