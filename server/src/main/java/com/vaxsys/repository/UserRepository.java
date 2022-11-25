package com.vaxsys.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.vaxsys.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {
    
	@Query("{email:'?0'}")
    User findByEmail(String email);

}