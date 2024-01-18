package com.cg.nursery.service;

import org.springframework.http.ResponseEntity;


import com.cg.nursery.exception.PlanterException;
import com.cg.nursery.model.Planter;

public interface IPlanterService {
	
	public ResponseEntity<?> addPlanter(Planter planter) throws PlanterException;
	
	public ResponseEntity<?> updatePlanter(Planter planter) throws PlanterException;
	
	public ResponseEntity<?> deletePlanter(int planterId) throws PlanterException;
	
	public ResponseEntity<?> viewPlanter(int planterId) throws PlanterException;
	
	public ResponseEntity<?> viewPlanter(String planterShape)throws PlanterException;
	
	public ResponseEntity<?> viewAllPlanters() throws PlanterException;
	
	public ResponseEntity<?> viewAllPlanters(double minCost,double maxCost) throws PlanterException;
	
	

}
