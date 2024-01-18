package com.cg.nursery.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.nursery.model.Planter;

@Repository
public interface IPlanterRepositary extends JpaRepository<Planter,Integer>{
	
	

}
