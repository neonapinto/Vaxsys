package com.vaxsys.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.vaxsys.model.Vaccine;

@Repository
public interface VaccineRepository extends MongoRepository<Vaccine, Long> {
    
    @Query("{diseaseName:'?0'}")
    List<Vaccine> findByDiseaseName(String diseaseName);
    
 
}