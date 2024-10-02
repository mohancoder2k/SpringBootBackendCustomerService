package com.mohan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

		// crud operations for our project
	
	// CustRepo interacts with JPARepository
}
