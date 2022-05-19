package com.service.Activate1.Model;

import java.util.List;


public class SupportingServiceSavePostRequestId {

	private String id;
	
	List<SupportingServiceSavePostRequest> supportingServiceSavePostRequests;

	public SupportingServiceSavePostRequestId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SupportingServiceSavePostRequestId(
			List<SupportingServiceSavePostRequest> supportingServiceSavePostRequests) {
		super();
		this.supportingServiceSavePostRequests = supportingServiceSavePostRequests;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<SupportingServiceSavePostRequest> getSupportingServiceSavePostRequests() {
		return supportingServiceSavePostRequests;
	}

	public void setSupportingServiceSavePostRequests(
			List<SupportingServiceSavePostRequest> supportingServiceSavePostRequests) {
		this.supportingServiceSavePostRequests = supportingServiceSavePostRequests;
	}
	
	
}
