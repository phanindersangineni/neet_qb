package com.neet.qb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.neet.qb.annotation.DefaultField;

@Document(collection = "center")
public class Center {
	
	@Id
	@DefaultField
	private String id;
	
	private String code;
	private String name;
	private String contactname;
	private Integer contactnumber;
	@Indexed
	private String addressId;
	private boolean isactive;
	@Indexed
	private String orgId;
	@Indexed
	private String stateId;
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
	public String getContactname() {
		return contactname;
	}
	public void setContactname(String contactname) {
		this.contactname = contactname;
	}
	public Integer getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(Integer contactnumber) {
		this.contactnumber = contactnumber;
	}
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public boolean isIsactive() {
		return isactive;
	}
	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getStateId() {
		return stateId;
	}
	public void setStateId(String stateId) {
		this.stateId = stateId;
	}
	
	
	
	
	
}
