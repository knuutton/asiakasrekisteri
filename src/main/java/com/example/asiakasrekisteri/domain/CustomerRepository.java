package com.example.asiakasrekisteri.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.asiakasrekisteri.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	//List<Customer> findByVatNumber(String vatNumber);
	List<Customer> findById(long customerId);
	//List<Customer> findByRestaurantName(String restaurant);
	
	
}
