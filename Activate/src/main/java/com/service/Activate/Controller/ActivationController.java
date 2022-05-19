package com.service.Activate.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.Activate.ExceptionHandler.CustomException;
import com.service.Activate.InterfaceService.ActivationService;
import com.service.Activate1.Model.MobileAccessSaveRequest;

import io.swagger.client.model.MobileAccessPostRequest;

@RestController
@RequestMapping("/api")
public class ActivationController {
	@Autowired
	private ActivationService activationService;

	@PostMapping("/activateConfiguration")
	public ResponseEntity<MobileAccessSaveRequest> saveData(@RequestBody MobileAccessPostRequest activationData,
			@RequestHeader(value = "X-Correlation-ID", required = true) String correlationId,
			@RequestHeader(value = "X-LatestVersion", required = false) String latestVersion,
			@RequestHeader(value = "X-Group-ID", required = true) String groupId,
			@RequestHeader(value = "X-SubGroup-ID", required = false) String subGroupId) throws CustomException {

		if (activationData == null)
			throw new CustomException("Please check the activation request data", HttpStatus.BAD_REQUEST);

		return activationService.activateService(activationData);

	}

	@GetMapping("/getData/{id}")
	public ResponseEntity<MobileAccessSaveRequest> getData(@PathVariable(value = "id", required = true) String id)
			throws CustomException {
		return activationService.getData(id);
	}

	@PutMapping("update")
	public ResponseEntity<MobileAccessSaveRequest> updateData(@RequestBody MobileAccessSaveRequest activationData)
			throws CustomException {
		return activationService.updateData(activationData);

	}
}
