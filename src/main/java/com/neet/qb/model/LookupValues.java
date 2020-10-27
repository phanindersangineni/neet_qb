package com.neet.qb.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="lookup_values")
public class LookupValues {

	private String code;
	private String name;
	
	public LookupValues() {
		
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
	public LookupValues(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
	
}
