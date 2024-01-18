package com.cg.nursery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.nursery.dao.IOrderRepository;

import com.cg.nursery.exception.OrderException;
import com.cg.nursery.model.Order;



@Service
public class OrderService implements IOrderService{
	@Autowired
	IOrderRepository dao;
	
	public ResponseEntity<Order> addOrder(Order ord) throws OrderException{
		if(ord==null || ord.getOrderDate()==null || ord.getTransactionMode()==null
				|| (Integer)ord.getQuantity()==null || (Double)ord.getTotalCost()==null || ord.getPlanters()==null)
			throw new OrderException("Can't addOrder as all necessary details are not provided");
			
		dao.save(ord);
		return new ResponseEntity<Order>(ord, HttpStatus.OK);
		
	}
	
	public ResponseEntity<Order> updateOrder(Order ord) throws OrderException{
		if(!dao.existsById(ord.getBookingOrderId()) || ord==null || ord.getOrderDate()==null || ord.getTransactionMode()==null
				|| (Integer)ord.getQuantity()==null || (Double)ord.getTotalCost()==null || ord.getPlanters()==null)
        {
			throw new OrderException("Can't update OrderDetails");
			
                
        }
		
		dao.save(ord);
		return new ResponseEntity<Order>(ord, HttpStatus.OK);
		
		
	}
	
	public ResponseEntity<Order> deleteOrder(int orderId) throws OrderException{
		if(dao.existsById(orderId))
        {
            
        
        Order o=dao.findById(orderId).get();
        dao.deleteById(orderId);
        return new ResponseEntity<Order>(o, HttpStatus.ACCEPTED);
                
        }
		throw new OrderException("No order with provided orderId so cant delete");
	}
	
	public ResponseEntity<Order> viewOrder(int orderId) throws OrderException{
		if(dao.existsById(orderId)) {
			Order o=dao.findById(orderId).get();
			return new ResponseEntity<Order>(o, HttpStatus.OK);
		}
		throw new OrderException("No order with provided orderId");
		
	}
	
	public ResponseEntity<List<Order>> viewAllOrders() throws OrderException{
		List<Order> ord=dao.findAll();
		if(ord.size()!=0) {
			return new ResponseEntity<List<Order>>(ord, HttpStatus.OK);
		}
		throw new OrderException("No Orders");
	}
	
	
	

}
