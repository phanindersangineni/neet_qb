package com.neet.qb.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.neet.qb.annotation.DefaultField;

@Document(collection = "role")
public class Role {
	
	@Id
	@DefaultField
	private String id;
	private String code;
	private String name;
	private List<RoleSubFeatures> rolesubfeatures = new ArrayList<>();
	
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
	public List<RoleSubFeatures> getRolesubfeatures() {
		return rolesubfeatures;
	}
	public void setRolesubfeatures(List<RoleSubFeatures> rolesubfeatures) {
		this.rolesubfeatures = rolesubfeatures;
	}	
	
	
	

}
