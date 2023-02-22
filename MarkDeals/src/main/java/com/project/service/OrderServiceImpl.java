package com.project.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.exception.OrderException;
import com.project.model.Order;
import com.project.model.Users;
import com.project.repository.OrderRepository;
import com.project.repository.UserRepository;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Order addOrder(Order order, String uEmail) throws OrderException {
		Users existingUser = userRepository.findByUserEmail(uEmail);
		order.setLocalDate(LocalDate.now());
		order.setProduct(existingUser.getCart().getProduct());
		order.setStatus("Processing");
		order.getPayment();
		order.getTotalAmount();
		existingUser.getOrders().add(order);
		return orderRepository.save(order);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
