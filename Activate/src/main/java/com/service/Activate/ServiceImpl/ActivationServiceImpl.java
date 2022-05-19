package com.service.Activate.ServiceImpl;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.service.Activate.ExceptionHandler.CustomException;
import com.service.Activate.InterfaceService.ActivationService;
import com.service.Activate1.Model.MobileAccessSaveRequest;

import io.swagger.client.model.MobileAccessPostRequest;

@Service
public class ActivationServiceImpl implements ActivationService {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private FormURLUtil formURLUtil;
	@Autowired
	private CircuitBreakerFactory circuitBreakerFactory;

	public ActivationServiceImpl(RestTemplate restTemplate, CircuitBreakerFactory circuitBreakerFactory, FormURLUtil formURLUtil) {
		super();
		this.restTemplate = restTemplate;
		this.circuitBreakerFactory = circuitBreakerFactory;
		this.formURLUtil = formURLUtil;
	}

	@Override
	public ResponseEntity<MobileAccessSaveRequest> activateService(MobileAccessPostRequest m) throws CustomException {
		URI uri = formURLUtil.formURL();
		String url = uri.toString() + "/api/saveData";
		System.out.println("from Service layered Entry");
		ResponseEntity<MobileAccessSaveRequest> postForEntity = restTemplate.postForEntity(url, m,
				MobileAccessSaveRequest.class);
//		CircuitBreaker circuitBreaker = circuitBreakerFactory.create("GetAssessmentCircuitBreaker");
//
//		ResponseEntity<MobileAccessSaveRequest> postForEntity = circuitBreaker.run(() -> restTemplate.postForEntity(url, m, MobileAccessSaveRequest.class),
//				throwable -> {
//					try {
//						return getDefaultValue();
//					} catch (CustomException e) {
//					}
//					return null;
//				});

		System.out.println("........................" + postForEntity);

		if (null == postForEntity)
			throw new CustomException("Persistence service failed", HttpStatus.BAD_GATEWAY);

		return postForEntity;

	}

	private ResponseEntity<MobileAccessSaveRequest> getDefaultValue() throws CustomException {
		throw new CustomException("Persistence service failed ", HttpStatus.BAD_GATEWAY);

	}

	@Override
	public ResponseEntity<MobileAccessSaveRequest> getData(String id) throws CustomException {
		URI uri = formURLUtil.formURL();
		String url = uri.toString() + "/api/getData/" + id;
		return restTemplate.getForEntity(url, MobileAccessSaveRequest.class);
	}

	@Override
	public ResponseEntity<MobileAccessSaveRequest> updateData(MobileAccessSaveRequest mobileAccessPostRequest) throws CustomException {
		URI uri = formURLUtil.formURL();
		String url = uri.toString() + "/api/update";
		//restTemplate.put(url, mobileAccessPostRequest);
		 HttpEntity<MobileAccessSaveRequest> requestEntity = new HttpEntity<MobileAccessSaveRequest>(mobileAccessPostRequest);
		ResponseEntity<MobileAccessSaveRequest> exchange = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, MobileAccessSaveRequest.class);
		return exchange;
	}

}
