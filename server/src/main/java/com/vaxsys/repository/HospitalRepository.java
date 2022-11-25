package com.vaxsys.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.vaxsys.model.Hospital;

@Repository
public interface HospitalRepository extends MongoRepository<Hospital, Long> {
    
    @Query("{_id:'?0'}")
    Hospital findByHospitalId(long id);
    

}