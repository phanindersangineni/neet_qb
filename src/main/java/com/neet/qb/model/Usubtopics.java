package com.neet.qb.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import com.neet.qb.annotation.DefaultField;

public class Usubtopics {
	
	@Id
	@DefaultField
	private ObjectId id;
	private String code;
	private String name;
	
	
	
	public Usubtopics() {
		
	}
	public String getId() {
		return id.toHexString();
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
