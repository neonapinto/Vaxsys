package com.vaxsys.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.vaxsys.model.HospitalAppointmentAvailability;

@Repository
public interface HospitalAppointmentAvailabilityRepo extends MongoRepository<HospitalAppointmentAvailability, Long> {
    
    @Query("{hospitalId: ?0}")
    List<HospitalAppointmentAvailability> findAvailabilityByHospitalId(Long hospitalId);
    

}