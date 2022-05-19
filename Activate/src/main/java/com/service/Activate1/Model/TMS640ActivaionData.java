package com.service.Activate1.Model;

import io.swagger.client.model.MobileAccessPostRequest;

public class TMS640ActivaionData {

	private String id;
	
	private MobileAccessPostRequest mobileAccessPostRequest;

	public TMS640ActivaionData(String id, MobileAccessPostRequest mobileAccessPostRequest) {
		super();
		this.id = id;
		this.mobileAccessPostRequest = mobileAccessPostRequest;
	}

	public TMS640ActivaionData() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public MobileAccessPostRequest getMobileAccessPostRequest() {
		return mobileAccessPostRequest;
	}

	public void setMobileAccessPostRequest(MobileAccessPostRequest mobileAccessPostRequest) {
		this.mobileAccessPostRequest = mobileAccessPostRequest;
	}

	@Override
	public String toString() {
		return "TMS640ActivaionData [id=" + id + ", mobileAccessPostRequest=" + mobileAccessPostRequest + "]";
	}


}
