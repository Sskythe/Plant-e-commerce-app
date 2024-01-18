package com.cg.nursery.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.nursery.model.Admin;



@Repository
public interface ILoginRepository extends JpaRepository<Admin, Integer>{
	
	@Query("select p from Admin p where p.adminUserName=:name and p.adminPassword=:password")
	public Admin adminlogin(@Param("name") String username,@Param("password") String password);
	
	
	
	
	


}
