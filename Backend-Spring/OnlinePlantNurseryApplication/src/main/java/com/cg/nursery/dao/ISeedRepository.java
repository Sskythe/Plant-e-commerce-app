package com.cg.nursery.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.nursery.model.Seed;
@Repository
public interface ISeedRepository extends JpaRepository<Seed, Integer> {
	
	
	@Query("select p from Seed p where commonName=:p1 ")
	Seed viewSeed(@Param("p1") String commonName);
	
	@Query("select p from Seed p where typeOfSeeds=:s ")
	List<Seed> viewAllSeed(@Param("s") String typeOfSeeds);
}
