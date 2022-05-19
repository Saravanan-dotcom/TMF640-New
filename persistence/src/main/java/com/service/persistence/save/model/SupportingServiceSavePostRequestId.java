package com.service.persistence.save.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("SupportingService")

public class SupportingServiceSavePostRequestId {


	@Id
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
