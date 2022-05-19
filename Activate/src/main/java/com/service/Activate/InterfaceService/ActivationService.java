package com.service.Activate.InterfaceService;

import org.springframework.http.ResponseEntity;

import com.service.Activate.ExceptionHandler.CustomException;
import com.service.Activate1.Model.MobileAccessSaveRequest;

import io.swagger.client.model.MobileAccessPostRequest;

public interface ActivationService {
	
	public ResponseEntity<MobileAccessSaveRequest> activateService(MobileAccessPostRequest m) throws CustomException;
	
	public ResponseEntity<MobileAccessSaveRequest> updateData(MobileAccessSaveRequest mobileAccessPostRequest) throws CustomException;
	
	public ResponseEntity<MobileAccessSaveRequest> getData(String id) throws CustomException;
}
