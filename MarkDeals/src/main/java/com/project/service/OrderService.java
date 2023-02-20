package com.project.service;

import java.util.List;

import com.project.exception.OrderException;
import com.project.model.Order;

public interface OrderService {
	
	public Order addOrder(Order order) throws OrderException;
	
	public List<Order> getAllOrders(Integer userId) throws OrderException;
	

}
