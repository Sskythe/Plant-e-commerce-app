package com.cg.nursery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.nursery.dao.ICustomerRepository;
import com.cg.nursery.exception.CustomerException;

import com.cg.nursery.model.Customer;
import com.cg.nursery.model.Plant;

@Service
public class CustomerService implements ICustomerService{
	@Autowired
	ICustomerRepository ir;
	

	//insert new Customer to database
	public ResponseEntity<?> addCustomer(Customer Customer) throws CustomerException{
		if(Customer==null || Customer.getUsername()==null ||Customer.getCustomerEmail()==null
				|| Customer.getPassword()==null || Customer.getUsername()==null ||
				Customer.getAddress()==null)
			throw new CustomerException("Can't add Customer ");
		ir.save(Customer);
		return new ResponseEntity<Customer>(Customer, HttpStatus.OK);
		
	}
	
	
	//update existing Customer in database
	public ResponseEntity<?> updateCustomer(Customer Customer) throws CustomerException {
		if(ir.existsById(Customer.getCustomerId())){
			ir.save(Customer);
			return new ResponseEntity<Customer>(Customer, HttpStatus.OK);
		}
		throw new CustomerException("No customer with provided orderId so cant update");
	}
	
	
	//delete Customer from database
	public ResponseEntity<?> deleteCustomer(int CustomerId) throws CustomerException {
		if(ir.existsById(CustomerId)) {
			Customer p=ir.findById(CustomerId).get();
	        ir.deleteById(CustomerId);
	        return new ResponseEntity<Customer>(p, HttpStatus.ACCEPTED);
		}
		throw new CustomerException("No customer with provided orderId so cant delete");
		
	}
	
	
	//retrival of a Customer by its ID
	public ResponseEntity<?> viewCustomer(int CustomerId) throws CustomerException {
		if(ir.existsById(CustomerId)) {
			Customer Customer=ir.findById(CustomerId).get();
			return new ResponseEntity<Customer>(Customer, HttpStatus.OK);
		}
		throw new CustomerException("No customer with provided orderId ");
	}
	
	

	
	//List of all Customer
	public ResponseEntity<?> viewAllCustomer() throws CustomerException {
		
		List<Customer> CustomerList=ir.findAll();
		if(CustomerList.size()==0)
			throw new CustomerException("No customer");
		return new ResponseEntity<List<Customer>>(CustomerList, HttpStatus.OK);
	}
	
	public ResponseEntity<?> validateCustomer(String username,String password) throws CustomerException {
		

		List<Customer> customers=ir.findAll();
		for(Customer c:customers) {
			if(c.getUsername().equals(username) && c.getUsername().equals(password)) {
				return new ResponseEntity<Customer>(c, HttpStatus.OK);
			}
		}
		
		throw new CustomerException("No customer with this details");
	}

}
