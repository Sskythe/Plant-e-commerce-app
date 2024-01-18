package com.cg.nursery.service;


import org.springframework.http.ResponseEntity;

import com.cg.nursery.exception.CustomerException;

import com.cg.nursery.model.Customer;

public interface ICustomerService {
	
	public ResponseEntity<?> addCustomer(Customer Customer) throws CustomerException;
	
	public ResponseEntity<?> updateCustomer(Customer Customer) throws CustomerException;
	
	public ResponseEntity<?> deleteCustomer(int CustomerId) throws CustomerException;
	
	public ResponseEntity<?> viewCustomer(int CustomerId) throws CustomerException;
	
	public ResponseEntity<?> viewAllCustomer() throws CustomerException;
	
	public ResponseEntity<?> validateCustomer(String username,String password) throws CustomerException;

}
