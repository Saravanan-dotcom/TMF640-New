package com.service.Activate1.Model;

import java.util.List;


public class RelatedPartySaveRequestId {
	
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
