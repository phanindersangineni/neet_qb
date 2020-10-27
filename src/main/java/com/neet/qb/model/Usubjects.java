package com.neet.qb.model;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

public class Usubjects {
	
	private ObjectId id;
	private String code;
	private String name;
	
	private List<Utopics> utopics =new ArrayList<>();
	
	
	public List<Utopics> getUtopics() {
		return utopics;
	}
	public void setUtopics(List<Utopics> utopics) {
		this.utopics = utopics;
	}
	public Usubjects() {
	
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
