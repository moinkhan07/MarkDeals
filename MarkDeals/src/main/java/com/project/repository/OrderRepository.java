package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

	public Order findByOrderId(Integer orderId);
	
}
