package com.service.Activate1.Model;

import java.util.List;

public class ServiceCharacteristicSaveRequestId {

	private String id;
	
	private List<ServiceCharacteristicSaveRequest> serviceCharacteristicSaveRequests;

	public ServiceCharacteristicSaveRequestId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServiceCharacteristicSaveRequestId(
			List<ServiceCharacteristicSaveRequest> serviceCharacteristicSaveRequests) {
		super();
		this.serviceCharacteristicSaveRequests = serviceCharacteristicSaveRequests;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<ServiceCharacteristicSaveRequest> getServiceCharacteristicSaveRequests() {
		return serviceCharacteristicSaveRequests;
	}

	public void setServiceCharacteristicSaveRequests(
			List<ServiceCharacteristicSaveRequest> serviceCharacteristicSaveRequests) {
		this.serviceCharacteristicSaveRequests = serviceCharacteristicSaveRequests;
	}
	
	
}
