package com.service.Activate1.Model;

import java.util.List;

import io.swagger.client.model.RelatedParty;
import io.swagger.client.model.ServiceCharacteristic;
import io.swagger.client.model.ServiceRelationship;
import io.swagger.client.model.ServiceSpecification;
import io.swagger.client.model.StateEnum;


public class SupportingServiceSavePostRequest {

	
	private String name;

	private String description;

	private StateEnum state;

	private ServiceSpecification serviceSpecification;

	private List<ServiceCharacteristic> serviceCharacteristic;

	private List<ServiceRelationship> serviceRelationship;

	private List<RelatedParty> relatedParty;

	public SupportingServiceSavePostRequest() {
		super();
	}

	public SupportingServiceSavePostRequest(String name, String description, StateEnum state,
			ServiceSpecification serviceSpecification, List<ServiceCharacteristic> serviceCharacteristic,
			List<ServiceRelationship> serviceRelationship, List<RelatedParty> relatedParty) {
		super();
		this.name = name;
		this.description = description;
		this.state = state;
		this.serviceSpecification = serviceSpecification;
		this.serviceCharacteristic = serviceCharacteristic;
		this.serviceRelationship = serviceRelationship;
		this.relatedParty = relatedParty;
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

	public List<ServiceCharacteristic> getServiceCharacteristic() {
		return serviceCharacteristic;
	}

	public void setServiceCharacteristic(List<ServiceCharacteristic> serviceCharacteristic) {
		this.serviceCharacteristic = serviceCharacteristic;
	}

	public List<ServiceRelationship> getServiceRelationship() {
		return serviceRelationship;
	}

	public void setServiceRelationship(List<ServiceRelationship> serviceRelationship) {
		this.serviceRelationship = serviceRelationship;
	}

	public List<RelatedParty> getRelatedParty() {
		return relatedParty;
	}

	public void setRelatedParty(List<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
	}

	
}
