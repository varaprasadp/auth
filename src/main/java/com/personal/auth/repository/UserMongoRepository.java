package com.personal.auth.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.personal.auth.model.User;


public interface UserMongoRepository extends UserRepository, MongoRepository<User, Integer>{
	@Query("{ 'email' : ?0 }")
	Optional<User> findByUserEmail(String email);

}
