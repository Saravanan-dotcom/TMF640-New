package com.service.persistence.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.service.persistence.save.model.SupportingServiceSavePostRequest;
import com.service.persistence.save.model.SupportingServiceSavePostRequestId;

public interface ConfigDataSave4  extends MongoRepository<SupportingServiceSavePostRequestId , String> {

}
