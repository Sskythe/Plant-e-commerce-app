package com.cg.nursery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.nursery.dao.ICustomerRepository;
import com.cg.nursery.dao.ILoginRepository;
import com.cg.nursery.exception.AuthException;

import com.cg.nursery.model.Admin;
import com.cg.nursery.model.Customer;



@Service
public class ILoginService {

	
	@Autowired
	ILoginRepository admin;
	
	@Autowired
	ICustomerRepository cust;
	
	public ResponseEntity<?> adminLogin(String username,String password) throws AuthException{
		
		
		Admin temp=admin.adminlogin(username, password);
		if(temp!=null)
			return new ResponseEntity<Admin>(temp, HttpStatus.OK);
		
		
		throw new AuthException("invalid credentials");
		
		
	}
//	public ResponseEntity<Admin> forgetPasswordAdmin(int userid,String name,String password) throws AuthException{
//		Admin temp;
//		if(admin.existsById(userid)) {
//			temp=admin.findById(userid).get();
//			temp.setPassword(password);
//			admin.save(temp);
//			return new ResponseEntity<Admin>(temp, HttpStatus.OK);
//		}
//		
//		throw new AuthException("Invalid details ");
//	}
	
	public ResponseEntity<?> forgetPasswordCustomer(int userid,String name,String password) throws AuthException{
		Customer temp;
		if(cust.existsById(userid)) {
			temp=cust.findById(userid).get();
			temp.setPassword(password);
			cust.save(temp);
			return new ResponseEntity<Customer>(temp, HttpStatus.OK);
		}
		
		throw new AuthException("Invalid details ");
	}



}
