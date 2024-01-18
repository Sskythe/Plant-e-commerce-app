package com.cg.nursery.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.nursery.exception.CustomerException;

import com.cg.nursery.model.Customer;
import com.cg.nursery.service.CustomerService;

@RestController
@RequestMapping("/Customer")
@CrossOrigin("*")
public class CustomerController {
	@Autowired
	CustomerService service;
	
	@PostMapping("/addCustomer")
	public ResponseEntity<?> addCustomer(@RequestBody Customer Customer) throws CustomerException{
		
		return service.addCustomer(Customer);
	}
	
	@PutMapping("/updateCustomer")
	public ResponseEntity<?> updateCustomer(@RequestBody Customer Customer) throws CustomerException{
		
		return service.updateCustomer(Customer);
	}
	
	@DeleteMapping("/deleteCustomer/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable("id") int customerId) throws CustomerException{
		return service.deleteCustomer(customerId);
	}
	
	@GetMapping("/viewCustomerById/{CustomerId}")
	public ResponseEntity<?> viewCustomer(@PathVariable("CustomerId") int id) throws CustomerException{
		return service.viewCustomer(id);
		

	}

	
	@GetMapping("/viewAllCustomer")
	public ResponseEntity<?> viewAllCustomer() throws CustomerException{
		return service.viewAllCustomer();
	}
	
	@GetMapping("/validateCustomer/{username}/{password}")
	public ResponseEntity<?> validateCustomer(@PathVariable("username") String name,@PathVariable("password") String pwd) throws CustomerException{
		return service.validateCustomer(name, pwd);
	}

}
