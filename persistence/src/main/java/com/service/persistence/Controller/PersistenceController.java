package com.service.persistence.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.persistence.ExceptionHandler.CustomException;
import com.service.persistence.Service.PersistenceService;
import com.service.persistence.save.model.MobileAccessSaveRequest;

import io.swagger.client.model.MobileAccessPostRequest;

@RestController
@RequestMapping("/api")
public class PersistenceController {

	@Autowired
	private PersistenceService persistenceService;

	@PostMapping("/saveData")
	public MobileAccessSaveRequest saveData(@RequestBody MobileAccessPostRequest s) throws CustomException {
		MobileAccessSaveRequest m = persistenceService.saveTMF640Data(s);
		System.out.println("from PersistenceController ====================" + m.toString());
		return m;
	}
	
	
	@GetMapping("/getData/{id}")
	public Optional<MobileAccessSaveRequest> getData(@PathVariable(value = "id") String id) throws CustomException {
		System.out.println("from PersistenceController ====================getData");
		Optional<MobileAccessSaveRequest> data = persistenceService.getData(id);
		return data;
	}

	
	@PutMapping("update")
	public ResponseEntity<MobileAccessSaveRequest> updateData(@RequestBody MobileAccessSaveRequest activationData)
			throws CustomException {
		System.out.println("from PersistenceController ====================updateData");
		MobileAccessSaveRequest updateData = persistenceService.updateData(activationData);
		return new ResponseEntity<MobileAccessSaveRequest>(updateData,HttpStatus.OK);

	}
}
