package com.training.mongodb.sample.infrastructure.repository;

import com.training.mongodb.sample.infrastructure.repository.entity.SucursalEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SucursalMongoRepository extends MongoRepository<SucursalEntity, String> {
}
