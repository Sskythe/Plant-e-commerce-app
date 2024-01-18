package com.cg.nursery.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cg.nursery.model.Plant;

@Repository
public interface IPlantRepository extends JpaRepository<Plant, Integer>{
	


}
