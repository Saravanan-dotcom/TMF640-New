package com.service.persistence.Service;

import java.util.Optional;

import com.service.persistence.ExceptionHandler.CustomException;
import com.service.persistence.save.model.MobileAccessSaveRequest;

import io.swagger.client.model.MobileAccessPostRequest;

public interface PersistenceService {

	public MobileAccessSaveRequest saveTMF640Data(MobileAccessPostRequest mobileAccessPostRequest) throws CustomException;
	
	public Optional<MobileAccessSaveRequest> getData(String id) throws CustomException;
	
	public MobileAccessSaveRequest updateData(MobileAccessSaveRequest mobileAccessPostRequest) throws CustomException;
}
