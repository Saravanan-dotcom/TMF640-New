package com.service.Activate.ServiceImpl;

import java.net.URI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.service.Activate.ExceptionHandler.CustomException;
import com.service.Activate.InterfaceService.ActivationService;
import com.service.Activate1.Model.MobileAccessSaveRequest;

import io.swagger.client.model.MobileAccessPostRequest;

@ExtendWith(MockitoExtension.class)
class ActivationServiceImplTest {
	
	private ActivationService activationService;
	
	@Mock
	private RestTemplate restTemplate;
	@Mock
	private FormURLUtil formURLUtil;
	@Mock
	private CircuitBreakerFactory circuitBreakerFactory;
	
	  @BeforeEach
	    void initUseCase() {
		  activationService = new ActivationServiceImpl(restTemplate,circuitBreakerFactory,formURLUtil);
	    }
	
	@Test
	void test() throws CustomException {
		MobileAccessPostRequest m = new MobileAccessPostRequest();
		URI uri = URI.create(String.format("http://%s:%s", "localhost", 9002));
		String url = uri.toString() + "/api/saveData";
		Mockito.when(formURLUtil.formURL()).thenReturn(uri);
		MobileAccessSaveRequest mobileAccessSaveRequest = new MobileAccessSaveRequest();
		ResponseEntity<MobileAccessSaveRequest> respActivationData = new ResponseEntity<MobileAccessSaveRequest>(
				mobileAccessSaveRequest, HttpStatus.CREATED);
		Mockito.when(restTemplate.postForEntity(url, m,MobileAccessSaveRequest.class)).thenReturn(respActivationData);
		activationService.activateService(m);
	}
	
	@Test
	void testSaveNull()  {
		MobileAccessPostRequest m = new MobileAccessPostRequest();
		URI uri = URI.create(String.format("http://%s:%s", "localhost", 9002));
		Mockito.when(formURLUtil.formURL()).thenReturn(uri);
		MobileAccessSaveRequest mobileAccessSaveRequest = new MobileAccessSaveRequest();
		ResponseEntity<MobileAccessSaveRequest> respActivationData = new ResponseEntity<MobileAccessSaveRequest>(
				mobileAccessSaveRequest, HttpStatus.CREATED);
		try {
			activationService.activateService(m);
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	void testGetData() throws CustomException {
		MobileAccessPostRequest m = new MobileAccessPostRequest();
		URI uri = URI.create(String.format("http://%s:%s", "localhost", 9002));
		String url = uri.toString() + "/api/getData/123456";
		Mockito.when(formURLUtil.formURL()).thenReturn(uri);
		MobileAccessSaveRequest mobileAccessSaveRequest = new MobileAccessSaveRequest();
		ResponseEntity<MobileAccessSaveRequest> respActivationData = new ResponseEntity<MobileAccessSaveRequest>(
				mobileAccessSaveRequest, HttpStatus.OK);
		Mockito.when(restTemplate.getForEntity(url,MobileAccessSaveRequest.class)).thenReturn(respActivationData);
		activationService.getData("1231426");
	}

}
