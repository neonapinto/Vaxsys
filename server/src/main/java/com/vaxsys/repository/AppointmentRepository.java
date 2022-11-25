package com.vaxsys.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.vaxsys.model.Appointment;

@Repository
public interface AppointmentRepository extends MongoRepository<Appointment, Long> {
    
    @Query("{email:'?0'}")
    Appointment findByEmail(String email);
    

}