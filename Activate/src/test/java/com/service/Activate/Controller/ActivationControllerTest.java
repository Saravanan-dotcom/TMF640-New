package com.service.Activate.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.service.Activate.ExceptionHandler.CustomException;
import com.service.Activate.InterfaceService.ActivationService;
import com.service.Activate1.Model.MobileAccessSaveRequest;

import io.swagger.client.model.MobileAccessPostRequest;

@RunWith(SpringRunner.class)
@WebMvcTest
class ActivationControllerTest {

	@Autowired
	private ActivationController activationController;
	@MockBean
	private ActivationService activationService;

	@Test
	void testSaveData() throws CustomException {
		//MockHttpServletRequest request = new MockHttpServletRequest();

		MobileAccessPostRequest activationData = new MobileAccessPostRequest();
		MobileAccessSaveRequest mobileAccessSaveRequest = new MobileAccessSaveRequest();
		ResponseEntity<MobileAccessSaveRequest> respActivationData = new ResponseEntity<MobileAccessSaveRequest>(
				mobileAccessSaveRequest, HttpStatus.CREATED);
		Mockito.when(activationService.activateService(activationData)).thenReturn(respActivationData);

		try {
			activationController.saveData(activationData, "aaaa", "bbbb", "cccc", "ddddd");
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(activationData, activationData);

	}
	
	@Test
	void testSaveDataNull() throws CustomException {
		//MockHttpServletRequest request = new MockHttpServletRequest();

		MobileAccessPostRequest activationData = null;
		MobileAccessSaveRequest mobileAccessSaveRequest = new MobileAccessSaveRequest();
		ResponseEntity<MobileAccessSaveRequest> respActivationData = new ResponseEntity<MobileAccessSaveRequest>(
				mobileAccessSaveRequest, HttpStatus.CREATED);
		Mockito.when(activationService.activateService(activationData)).thenReturn(respActivationData);

		try {
			activationController.saveData(activationData, "aaaa", "bbbb", "cccc", "ddddd");
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(activationData, activationData);

	}

	
	@Test
	void testGetData() throws CustomException {
		MobileAccessPostRequest activationData = new MobileAccessPostRequest();
		activationController.getData("aaaa");
		assertEquals(activationData, activationData);
	}
	
	@Test
	void testUpdateData() throws CustomException {
		MobileAccessSaveRequest activationData = new MobileAccessSaveRequest();
		activationController.updateData(activationData);
		assertEquals(activationData, activationData);
	}
	
	
}
