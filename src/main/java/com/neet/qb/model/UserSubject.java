package com.neet.qb.model;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import com.neet.qb.annotation.DefaultField;

public class UserSubject {
	
	@Id
	@DefaultField
	private ObjectId id;
	
	private ObjectId userid;
	
	private List<Usubjects> usbjects =new ArrayList<>();

	public String getId() {
		return id.toHexString();
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getUserid() {
		return userid.toHexString();
	}

	public void setUserid(ObjectId userid) {
		this.userid = userid;
	}

	public List<Usubjects> getUsbjects() {
		return usbjects;
	}

	public void setUsbjects(List<Usubjects> usbjects) {
		this.usbjects = usbjects;
	}
	
	
	

}
