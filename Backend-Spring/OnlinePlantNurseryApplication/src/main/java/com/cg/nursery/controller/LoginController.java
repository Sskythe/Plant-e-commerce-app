package com.cg.nursery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.nursery.exception.AuthException;
import com.cg.nursery.exception.CustomerException;
import com.cg.nursery.model.Admin;
import com.cg.nursery.model.Customer;
import com.cg.nursery.service.ICustomerService;
import com.cg.nursery.service.ILoginService;

@RestController
@RequestMapping("/login")
@CrossOrigin("*")
public class LoginController {
	
	@Autowired
	ILoginService service;
	
	@Autowired
	ICustomerService cust;
	
	@GetMapping("/signinAdmin/{username}/{password}")
	public ResponseEntity<?> adminlogin(@PathVariable("username") String name,@PathVariable("password") String pwd) throws AuthException{
		return service.adminLogin(name, pwd);
		
	}
//	@PutMapping("/admin/{userid}/{username}/{password}")
//	public ResponseEntity<Admin> updateAdminPwd(@PathVariable("userid") int id,@PathVariable("username") String name,@PathVariable("password") String pwd) throws AuthException{
//		return service.forgetPasswordAdmin( id, name,pwd);
//	}

	

	@GetMapping("/signinCustomer/{username}/{password}")
	public ResponseEntity<?> customerLogin(@PathVariable("username") String name,@PathVariable("password") String pwd) throws AuthException, CustomerException{
		return cust.validateCustomer(name, pwd);
	}


	
	@PutMapping("/Customer/{userid}/{username}/{password}")
	public ResponseEntity<?> updateCustomerPwd(@PathVariable("userid") int id,@PathVariable("username") String name,@PathVariable("password") String pwd) throws AuthException, CustomerException{
		return service.forgetPasswordCustomer(id,name, pwd);
	}
	
	@GetMapping("/logout")
	public ResponseEntity<Customer> logOut(){
		return null;
		
	}


}
