package com.neet.qb.model;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.neet.qb.annotation.DefaultField;

@Document(collection = "topic")
public class Topic {
	
	@Id
	@DefaultField
	private ObjectId id;
	
	 private String code;
	 private String name;
	 private String  description;
	 @Indexed
     private ObjectId subjectId;
	 
	 
	public Topic() {
		super();
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSubjectId() {
		return subjectId.toHexString();
	}
	public void setSubjectId(ObjectId subjectId) {
		this.subjectId = subjectId;
	}
	
	 
	 
}
