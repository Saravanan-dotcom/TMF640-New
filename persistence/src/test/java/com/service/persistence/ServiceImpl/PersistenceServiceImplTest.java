package com.service.persistence.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.service.persistence.ExceptionHandler.CustomException;
import com.service.persistence.Repo.ConfigDataSave;
import com.service.persistence.Repo.ConfigDataSave2;
import com.service.persistence.Repo.ConfigDataSave3;
import com.service.persistence.Repo.ConfigDataSave4;
import com.service.persistence.Service.PersistenceService;
import com.service.persistence.save.model.MobileAccessSaveRequest;
import com.service.persistence.save.model.RelatedPartySaveRequest;

import io.swagger.client.model.MobileAccessPostRequest;
import io.swagger.client.model.RelatedParty;
import io.swagger.client.model.ServiceCharacteristic;
import io.swagger.client.model.SupportingServiceCreatePostRequest;

@ExtendWith(MockitoExtension.class)
class PersistenceServiceImplTest {

	private PersistenceService persistenceService;
	@Mock
	private ConfigDataSave configDataSave;
	@Mock
	private ConfigDataSave2 configDataSave2;
	@Mock
	private ConfigDataSave3 configDataSave3;
	@Mock
	private ConfigDataSave4 configDataSave4;

	@BeforeEach
	void initUseCase() {
		persistenceService = new PersistenceServiceImpl(configDataSave, configDataSave2, configDataSave3,
				configDataSave4);
	}

	@Test
	void testSaveTMF640Data() throws CustomException {

		MobileAccessPostRequest m = new MobileAccessPostRequest();

		List<RelatedParty> relatedParty = m.getRelatedParty();
		RelatedParty r = new RelatedParty();
		r.setName("aaa");
		r.setRole("role");
		relatedParty.add(r);

		List<ServiceCharacteristic> serviceCharacteristic = m.getServiceCharacteristic();
		ServiceCharacteristic s = new ServiceCharacteristic();
		s.setName("aaa");
		s.setValue("aaa");

		List<SupportingServiceCreatePostRequest> supportingService = m.getSupportingService();

		SupportingServiceCreatePostRequest ss = new SupportingServiceCreatePostRequest();
		ss.setName("aaaaa");

		m.setRelatedParty(relatedParty);
		m.setServiceCharacteristic(serviceCharacteristic);
		m.setSupportingService(supportingService);
		SupportingServiceCreatePostRequest service = new SupportingServiceCreatePostRequest();
		List<SupportingServiceCreatePostRequest> services = new ArrayList<SupportingServiceCreatePostRequest>();
		services.add(service);

		m.addSupportingServiceItem(service);
		List<RelatedPartySaveRequest> relatedPartySaveRequests = new ArrayList<RelatedPartySaveRequest>();

		RelatedPartySaveRequest relatedPartySaveRequest = new RelatedPartySaveRequest();
		relatedPartySaveRequest.setRole("role");
		// relatedPartySaveRequest.setId("1");
		relatedPartySaveRequest.setName("aaa");
		relatedPartySaveRequests.add(relatedPartySaveRequest);

		persistenceService.saveTMF640Data(m);
	}

	@Test
	void testGetData() throws CustomException {
		MobileAccessSaveRequest s = new MobileAccessSaveRequest();
		Optional<MobileAccessSaveRequest> mobileAccessSaveRequest = Optional.of(s);
		persistenceService.getData("aaaaaaa");
	}
	
	
	@Test
	void testUpdateData() throws CustomException {
		MobileAccessSaveRequest mobileAccessPostRequest = new MobileAccessSaveRequest();
		persistenceService.updateData(mobileAccessPostRequest);
	}

}
