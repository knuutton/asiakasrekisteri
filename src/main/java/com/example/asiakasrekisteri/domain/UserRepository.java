package com.example.asiakasrekisteri.domain;

import org.springframework.data.repository.CrudRepository;

import com.example.asiakasrekisteri.model.User;

//User repository config
public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByUsername(String username);
	
}
