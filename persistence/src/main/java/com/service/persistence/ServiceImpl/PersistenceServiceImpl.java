package com.service.persistence.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.persistence.ExceptionHandler.CustomException;
import com.service.persistence.Repo.ConfigDataSave;
import com.service.persistence.Repo.ConfigDataSave2;
import com.service.persistence.Repo.ConfigDataSave3;
import com.service.persistence.Repo.ConfigDataSave4;
import com.service.persistence.Service.PersistenceService;
import com.service.persistence.save.model.MobileAccessSaveRequest;
import com.service.persistence.save.model.RelatedPartySaveRequest;
import com.service.persistence.save.model.RelatedPartySaveRequestId;
import com.service.persistence.save.model.ServiceCharacteristicSaveRequest;
import com.service.persistence.save.model.ServiceCharacteristicSaveRequestId;
import com.service.persistence.save.model.SupportingServiceSavePostRequest;
import com.service.persistence.save.model.SupportingServiceSavePostRequestId;

import io.swagger.client.model.MobileAccessPostRequest;

@Service
public class PersistenceServiceImpl implements PersistenceService {

	@Autowired
	private ConfigDataSave configDataSave;
	@Autowired
	private ConfigDataSave2 configDataSave2;
	@Autowired
	private ConfigDataSave3 configDataSave3;
	@Autowired
	private ConfigDataSave4 configDataSave4;

	public PersistenceServiceImpl(ConfigDataSave configDataSave, ConfigDataSave2 configDataSave2,
			ConfigDataSave3 configDataSave3, ConfigDataSave4 configDataSave4) {
		super();
		this.configDataSave = configDataSave;
		this.configDataSave2 = configDataSave2;
		this.configDataSave3 = configDataSave3;
		this.configDataSave4 = configDataSave4;
	}

	@Override
	public MobileAccessSaveRequest saveTMF640Data(MobileAccessPostRequest mobileAccessPostRequest)
			throws CustomException {

		MobileAccessSaveRequest save = null;

		MobileAccessSaveRequest dataMappaing = dataMappaing(mobileAccessPostRequest);
		try {
			save = configDataSave.insert(dataMappaing);
			System.out.println("saved data" + save.toString());
		} catch (Exception e) {
			System.out.println(e);
		}
		return save;

	}

	private MobileAccessSaveRequest dataMappaing(MobileAccessPostRequest mobileAccessPostRequest) {

		MobileAccessSaveRequest mobileAccessSaveRequest = new MobileAccessSaveRequest();

		mobileAccessSaveRequest.setName(mobileAccessPostRequest.getName());
		mobileAccessSaveRequest.setState(mobileAccessPostRequest.getState());
		mobileAccessSaveRequest.setDescription(mobileAccessPostRequest.getDescription());

		List<RelatedPartySaveRequest> relatedPartySaveRequests = mobileAccessPostRequest.getRelatedParty().stream()
				.map(m -> new RelatedPartySaveRequest(m.getRole(), m.getName())).collect(Collectors.toList());

		List<ServiceCharacteristicSaveRequest> serviceCharacteristicSaveRequests = mobileAccessPostRequest
				.getServiceCharacteristic().stream()
				.map(m -> new ServiceCharacteristicSaveRequest(m.getName(), m.getValue())).collect(Collectors.toList());

		List<SupportingServiceSavePostRequest> supportingServiceSavePostRequests = mobileAccessPostRequest
				.getSupportingService().stream()
				.map(m -> new SupportingServiceSavePostRequest(m.getName(), m.getDescription(), m.getState(),
						m.getServiceSpecification(), m.getServiceCharacteristic(), m.getServiceRelationship(),
						m.getRelatedParty()))
				.collect(Collectors.toList());

		RelatedPartySaveRequestId save = configDataSave2.save(new RelatedPartySaveRequestId(relatedPartySaveRequests));
		// ServiceCharacteristicSaveRequestId
		ServiceCharacteristicSaveRequestId save2 = configDataSave3
				.save(new ServiceCharacteristicSaveRequestId(serviceCharacteristicSaveRequests));
		SupportingServiceSavePostRequestId save3 = configDataSave4
				.save(new SupportingServiceSavePostRequestId(supportingServiceSavePostRequests));

		mobileAccessSaveRequest.setRelatedPartySaveRequest(save);
		mobileAccessSaveRequest.setServiceCharacteristicSaveRequest(save2);
		mobileAccessSaveRequest.setSupportingServiceSavePostRequest(save3);

		return mobileAccessSaveRequest;

	}

	@Override
	public Optional<MobileAccessSaveRequest> getData(String id) throws CustomException {
		Optional<MobileAccessSaveRequest> findById = configDataSave.findById(id);
		return findById;
	}

	@Override
	public MobileAccessSaveRequest updateData(MobileAccessSaveRequest mobileAccessSaveRequest) throws CustomException {

		RelatedPartySaveRequestId save = configDataSave2.save(mobileAccessSaveRequest.getRelatedPartySaveRequest());
		ServiceCharacteristicSaveRequestId save2 = configDataSave3
				.save(mobileAccessSaveRequest.getServiceCharacteristicSaveRequest());
		SupportingServiceSavePostRequestId save3 = configDataSave4
				.save(mobileAccessSaveRequest.getSupportingServiceSavePostRequest());
		mobileAccessSaveRequest.setRelatedPartySaveRequest(save);
		mobileAccessSaveRequest.setServiceCharacteristicSaveRequest(save2);
		mobileAccessSaveRequest.setSupportingServiceSavePostRequest(save3);
		return configDataSave.save(mobileAccessSaveRequest);
	}

}
