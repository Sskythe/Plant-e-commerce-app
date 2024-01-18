package com.cg.nursery.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cg.nursery.model.Customer;


@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer>{
	
	
}
