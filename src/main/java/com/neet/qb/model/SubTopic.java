package com.neet.qb.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.neet.qb.annotation.DefaultField;

@Document(collection="subtopic")
public class SubTopic {
	
	@Id
	@DefaultField
	private ObjectId id;
	 private String code;
	 private String name;
	 private String  description;
	 @Indexed
     private ObjectId topicId;
	 
	
	public String getId() {
		return id.toHexString();
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public SubTopic() {

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
	public ObjectId getTopicId() {
		return topicId;
	}
	public void setTopicId(ObjectId topicId) {
		this.topicId = topicId;
	}
	
	
	 
}
