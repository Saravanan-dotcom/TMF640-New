package com.service.persistence.Controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.service.persistence.ExceptionHandler.CustomException;
import com.service.persistence.Service.PersistenceService;
import com.service.persistence.save.model.MobileAccessSaveRequest;

import io.swagger.client.model.MobileAccessPostRequest;

@RunWith(SpringRunner.class)
@WebMvcTest
class PersistenceControllerTest {

	@Autowired
	private PersistenceController persistenceController;
	@MockBean
	private PersistenceService persistenceService;

	@Test
	void testSaveData() throws CustomException {
		MobileAccessPostRequest activationData = new MobileAccessPostRequest();
		MobileAccessSaveRequest s = new MobileAccessSaveRequest();
		Mockito.when(persistenceService.saveTMF640Data(activationData)).thenReturn(s);
		persistenceController.saveData(activationData);
	}
	
	@Test
	void testGetData() throws CustomException {
		MobileAccessSaveRequest s = new MobileAccessSaveRequest();
		Optional<MobileAccessSaveRequest> mobileAccessSaveRequest = Optional.of(s);
		Mockito.when(persistenceService.getData("123456")).thenReturn(mobileAccessSaveRequest);
		persistenceController.getData("123456");
	}
	
	@Test
	void testUpdateData() throws CustomException {
		MobileAccessPostRequest activationData = new MobileAccessPostRequest();
		MobileAccessSaveRequest s = new MobileAccessSaveRequest();
		Mockito.when(persistenceService.updateData(s)).thenReturn(s);
		persistenceController.updateData(s);
	}


}
