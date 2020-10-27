package com.neet.qb.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.neet.qb.annotation.DefaultField;

@Document(collection = "state")
public class State {
	
	@Id
	@DefaultField
	private ObjectId  id;
	@Indexed
	 private ObjectId countryId;
	
	 private String statecode;
	 private String statename;
	public String  getId() {
		return id.toHexString();
	}
	public void setId(ObjectId  id) {
		this.id = id;
	}
	
	
	public String getCountryId() {
		return countryId.toHexString();
	}
	public void setCountryId(ObjectId countryId) {
		this.countryId = countryId;
	}
	public String getStatecode() {
		return statecode;
	}
	public void setStatecode(String statecode) {
		this.statecode = statecode;
	}
	public String getStatename() {
		return statename;
	}
	public void setStatename(String statename) {
		this.statename = statename;
	}
	
	 
}
