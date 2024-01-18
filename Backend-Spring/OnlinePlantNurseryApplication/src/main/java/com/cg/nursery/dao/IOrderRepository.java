package com.cg.nursery.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.nursery.model.Order;

@Repository
	public interface IOrderRepository  extends JpaRepository<Order, Integer> {
		

	}

