package com.service.persistence.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.service.persistence.save.model.RelatedPartySaveRequest;
import com.service.persistence.save.model.RelatedPartySaveRequestId;

public interface ConfigDataSave2  extends MongoRepository<RelatedPartySaveRequestId , String> {

}
