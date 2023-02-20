package com.project.service;

import com.project.exception.OrderException;
import com.project.model.Order;

public interface OrderService {
	
	public Order addOrder(Order order,Integer uId) throws OrderException;
	
//	public Order getAllOrders(String userEmail) throws OrderException;
	

}
