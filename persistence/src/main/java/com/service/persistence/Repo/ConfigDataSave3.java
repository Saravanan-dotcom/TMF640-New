package com.service.persistence.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.service.persistence.save.model.ServiceCharacteristicSaveRequest;
import com.service.persistence.save.model.ServiceCharacteristicSaveRequestId;

public interface ConfigDataSave3  extends MongoRepository<ServiceCharacteristicSaveRequestId, String> {

}
