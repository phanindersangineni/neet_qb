package com.neet.qb.model;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import com.neet.qb.annotation.DefaultField;

public class Utopics {
	
	@Id
	@DefaultField
	private ObjectId id;
	private String code;
	private String name;
	
	private List<Usubtopics> usubtopics =new ArrayList<>();
	
	
	public List<Usubtopics> getUsubtopics() {
		return usubtopics;
	}
	public void setUsubtopics(List<Usubtopics> usubtopics) {
		this.usubtopics = usubtopics;
	}
	public Utopics() {
	
	}
	public ObjectId getId() {
		return id;
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
