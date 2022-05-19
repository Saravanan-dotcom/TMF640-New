package com.service.persistence.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.service.persistence.save.model.MobileAccessSaveRequest;

public interface ConfigDataSave extends MongoRepository<MobileAccessSaveRequest, String> {

}
