package com.hacisimsek.auth_api.repositories;

import com.hacisimsek.auth_api.entities.CacheData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CacheDataRepository extends CrudRepository<CacheData, String> {

}