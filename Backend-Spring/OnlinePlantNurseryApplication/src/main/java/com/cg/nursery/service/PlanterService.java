package com.cg.nursery.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.nursery.dao.IPlanterRepositary;

import com.cg.nursery.exception.PlanterException;
import com.cg.nursery.model.Planter;

@Service
public class PlanterService implements IPlanterService{
	
	@Autowired
	IPlanterRepositary dao;
	

	
	public ResponseEntity<?> addPlanter(Planter planter) throws PlanterException{
		
		if(planter==null)
			throw new PlanterException("can't add");
		dao.save(planter);
		return new ResponseEntity<Planter>(planter, HttpStatus.OK);
	}
	
	
	
	
	public ResponseEntity<?> updatePlanter(Planter planter) throws PlanterException{
		if(dao.existsById(planter.getPlanterId()))
        {
            
        
        dao.save(planter);
        return new ResponseEntity<Planter>(planter, HttpStatus.OK); 
                
        }
		throw new PlanterException("can't update");
	}
	
	
	
	
	public ResponseEntity<?> deletePlanter(int planterId) throws PlanterException{
		if(dao.existsById(planterId))
        {
            
        
        Planter p=dao.findById(planterId).get();
        dao.deleteById(planterId);
        return new ResponseEntity<Planter>(p, HttpStatus.OK); 
                
        }
		throw new PlanterException("No Planter With provided planterId");
		
	}
	
	
	public ResponseEntity<?> viewPlanter(int planterId)throws PlanterException {
		if(dao.existsById(planterId)) {
			Planter p=dao.findById(planterId).get();
			return new ResponseEntity<Planter>(p, HttpStatus.OK);
		}
		throw new PlanterException("No Planter With provided planterId");
	}
	
	
	public ResponseEntity<?> viewPlanter(String planterShape)throws PlanterException {
		
		
		
		List<Planter> all=dao.findAll();
		List<Planter> needed=new ArrayList<Planter>();
		if(all.size()!=0) {
		for(Planter p:all) {
			if(p.getPlanterShape().equals(planterShape)) {
				needed.add(p);
				
			}
		}
		
		
		
	}
		if(needed.size()!=0) {
			return new ResponseEntity<List<Planter>>(needed, HttpStatus.OK);
		}
		throw new PlanterException("No Planter Available with this planterShape");
		
	}
	
	public ResponseEntity<?> viewAllPlanters() throws PlanterException{
		List<Planter> all=dao.findAll();
		if(all.size()==0)
			throw new PlanterException("No Planter Available");
		return new ResponseEntity<List<Planter>>(all, HttpStatus.OK);
	}
	
	public ResponseEntity<?> viewAllPlanters(double minCost,double maxCost) throws PlanterException{
		List<Planter> all=dao.findAll();
		List<Planter> needed=new ArrayList<Planter>();
		if(all.size()!=0) {
		for(Planter p:all) {
			float cost=(float) p.getPlanterCost();
			if(cost>= minCost && cost<=maxCost) {
				needed.add(p);
			}
			
		}
		
		
	}
		if(needed.size()!=0) {
			return new ResponseEntity<List<Planter>>(needed, HttpStatus.OK);
		}
		throw new PlanterException("No Planter Available");
		
	}
	

}
