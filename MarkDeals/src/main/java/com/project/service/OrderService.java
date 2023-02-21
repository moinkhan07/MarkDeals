package com.project.service;

import com.project.exception.OrderException;
import com.project.model.Order;
import com.project.model.Users;

public interface OrderService {
	
	public Order addOrder(Users users) throws OrderException;
	
//	public List<Order> getAllOrders(String userEmail) throws OrderException;
	

}
