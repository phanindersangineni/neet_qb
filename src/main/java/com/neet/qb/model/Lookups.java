package com.neet.qb.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.neet.qb.annotation.DefaultField;

@Document(collection="lookup_types")
public class Lookups {
	
	 @Id
	 @DefaultField
	  private String id;
	  private String code;
	  private String name;
	 
	private List<LookupValues> lookupvalues = new ArrayList<>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public List<LookupValues> getLookupvalues() {
		return lookupvalues;
	}
	public void setLookupvalues(List<LookupValues> lookupvalues) {
		this.lookupvalues = lookupvalues;
	}
	/*public Lookups(int id, String code, String name, List<LookupValues> lookupvalues) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.lookupvalues = lookupvalues;
	}	
	  
	 @Override
	    public String toString() {
	      ObjectMapper mapper = new ObjectMapper();
	      
	      String jsonString = "";
	    try {
	      mapper.enable(SerializationFeature.INDENT_OUTPUT);
	      jsonString = mapper.writeValueAsString(this);
	    } catch (JsonProcessingException e) {
	      e.printStackTrace();
	    }
	    
	      return jsonString;
	    }
	  */

}
