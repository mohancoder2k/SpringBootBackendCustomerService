package com.mohan;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.NoResultException;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService cust;
	
	@GetMapping("/customerservice")
	public List<Customer> getAllCustomers(){
		return cust.listAll();
	}
	@PostMapping("/customerservice")
	public void add(@RequestBody Customer cust1) {
		cust.save(cust1);
	}
	  @GetMapping("/customerservice/{id}")
	    public ResponseEntity<Customer> get(@PathVariable Integer id) {
	        Optional<Customer> customerOptional = cust.get(id);
	        if (customerOptional.isPresent()) {
	            // If the customer exists, return it with an HTTP 200 status
	            return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
	        } else {
	            // If the customer is not found, return HTTP 404 status
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	
	@DeleteMapping("/customerservice/{id}")
	public void delete(@PathVariable Integer id) {
		cust.delete(id);
	}
	@PutMapping("/customerservice/{id}")
	public ResponseEntity<?> update(@RequestBody Customer customer, @PathVariable Integer id) {
	    Optional<Customer> customerOptional = cust.get(id);
	    
	    if (customerOptional.isPresent()) {
	        
	        Customer existingCustomer = customerOptional.get();
	        existingCustomer.setName(customer.getName());
	        existingCustomer.setAddress(customer.getAddress());
	        
	        cust.save(existingCustomer); // Save the updated customer
	        
	        return new ResponseEntity<>(existingCustomer, HttpStatus.OK);
	    } else {
	        // If customer is not found, return 404 Not Found
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}

}
