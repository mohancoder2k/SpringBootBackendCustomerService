package com.mohan;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerService {
	
	@Autowired
	private CustomerRepository repo; // obj for Cust. Repo 
	
	//Get all the records from the tables
	
	public List<Customer> listAll(){
		return repo.findAll();
	}
	
	// save the record 
	public void save(Customer cust) {
		repo.save(cust);
	}
	//Retreiving particular id 
	public Optional<Customer> get(Integer id) {
	    return repo.findById(id);
	}
	//Deleting the record
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	public void update(Customer cust) {
		repo.save(cust);
	}

}
