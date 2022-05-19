package com.service.persistence.save.model;

import org.springframework.data.mongodb.core.mapping.Document;


public class RelatedPartySaveRequest {

	private String role;

	private String name;

	public RelatedPartySaveRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RelatedPartySaveRequest(String role, String name) {
		super();
		this.role = role;
		this.name = name;
	}

//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "RelatedPartySaveRequest [role=" + role + ", name=" + name + "]";
	}

	
}
