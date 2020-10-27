package com.neet.qb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.neet.qb.annotation.DefaultField;

@Document(collection = "country")
public class Country {
	
	@Id
	  @DefaultField
	  private String id;
	
	 private String countrycode;
	 private String countryname;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCountrycode() {
		return countrycode;
	}
	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}
	public String getCountryname() {
		return countryname;
	}
	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}
	 
	 
}
