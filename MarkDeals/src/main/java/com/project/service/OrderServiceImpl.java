package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.exception.OrderException;
import com.project.model.Order;
import com.project.repository.OrderRepository;
import com.project.repository.UserRepository;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Order addOrder(Order order) throws OrderException {
		return orderRepository.save(order);
	}

//	@Override
//	public List<Order> getAllOrders(String userEmail) throws OrderException {
//	return null;
//	}
	
	

}
