package com.service.Activate1.Model;


import io.swagger.client.model.ServiceSpecification;
import io.swagger.client.model.StateEnum;


public class MobileAccessSaveRequest {

	private String id;

	private String name;

	private String description;

	private StateEnum state;

	private ServiceSpecification serviceSpecification;
	private RelatedPartySaveRequestId relatedPartySaveRequest;
	private ServiceCharacteristicSaveRequestId serviceCharacteristicSaveRequest;
	private SupportingServiceSavePostRequestId supportingServiceSavePostRequest;

	public MobileAccessSaveRequest() {
		super();
	}

	public MobileAccessSaveRequest(String name, String description, StateEnum state,
			ServiceSpecification serviceSpecification, RelatedPartySaveRequestId relatedPartySaveRequest,
			ServiceCharacteristicSaveRequestId serviceCharacteristicSaveRequest,
			SupportingServiceSavePostRequestId supportingServiceSavePostRequest) {
		super();
		this.name = name;
		this.description = description;
		this.state = state;
		this.serviceSpecification = serviceSpecification;
		this.relatedPartySaveRequest = relatedPartySaveRequest;
		this.serviceCharacteristicSaveRequest = serviceCharacteristicSaveRequest;
		this.supportingServiceSavePostRequest = supportingServiceSavePostRequest;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public RelatedPartySaveRequestId getRelatedPartySaveRequest() {
		return relatedPartySaveRequest;
	}

	public void setRelatedPartySaveRequest(RelatedPartySaveRequestId relatedPartySaveRequest) {
		this.relatedPartySaveRequest = relatedPartySaveRequest;
	}

	public ServiceCharacteristicSaveRequestId getServiceCharacteristicSaveRequest() {
		return serviceCharacteristicSaveRequest;
	}

	public void setServiceCharacteristicSaveRequest(
			ServiceCharacteristicSaveRequestId serviceCharacteristicSaveRequest) {
		this.serviceCharacteristicSaveRequest = serviceCharacteristicSaveRequest;
	}

	public SupportingServiceSavePostRequestId getSupportingServiceSavePostRequest() {
		return supportingServiceSavePostRequest;
	}

	public void setSupportingServiceSavePostRequest(
			SupportingServiceSavePostRequestId supportingServiceSavePostRequest) {
		this.supportingServiceSavePostRequest = supportingServiceSavePostRequest;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public StateEnum getState() {
		return state;
	}

	public void setState(StateEnum state) {
		this.state = state;
	}

	public ServiceSpecification getServiceSpecification() {
		return serviceSpecification;
	}

	public void setServiceSpecification(ServiceSpecification serviceSpecification) {
		this.serviceSpecification = serviceSpecification;
	}

	@Override
	public String toString() {
		return "MobileAccessSaveRequest [id=" + id + ", name=" + name + ", description=" + description + ", state="
				+ state + ", serviceSpecification=" + serviceSpecification + ", relatedPartySaveRequest="
				+ relatedPartySaveRequest + ", serviceCharacteristicSaveRequest=" + serviceCharacteristicSaveRequest
				+ ", supportingServiceSavePostRequest=" + supportingServiceSavePostRequest + "]";
	}
	
	

}
