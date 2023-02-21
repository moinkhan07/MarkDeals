package com.project.service;

import com.project.exception.OrderException;
import com.project.model.Order;
import com.project.model.Payment;
import com.project.model.Users;

public interface OrderService {
	
	public Order addOrder(String userEmail ,Double amt,Payment payment) throws OrderException;
	
//	public List<Order> getAllOrders(String userEmail) throws OrderException;
	

}
