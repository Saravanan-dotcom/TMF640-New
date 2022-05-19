package com.service.persistence.save.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("RelatedPartyService")
public class RelatedPartySaveRequestId {
	
	@Id
	private String id;
	
	private List<RelatedPartySaveRequest> relatedPartySaveRequest;

	public RelatedPartySaveRequestId(List<RelatedPartySaveRequest> relatedPartySaveRequest) {
		super();
		this.relatedPartySaveRequest = relatedPartySaveRequest;
	}

	public RelatedPartySaveRequestId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<RelatedPartySaveRequest> getRelatedPartySaveRequest() {
		return relatedPartySaveRequest;
	}

	public void setRelatedPartySaveRequest(List<RelatedPartySaveRequest> relatedPartySaveRequest) {
		this.relatedPartySaveRequest = relatedPartySaveRequest;
	}
	
	
}
