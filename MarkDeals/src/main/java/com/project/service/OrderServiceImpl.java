package com.project.service;

import java.time.LocalDate;
import java.util.Optional;

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
	public Order addOrder(Order order) throws OrderException {
		order.setStatus("Processing");
		order.setPlacedDate(LocalDate.now()); 
		order.getProduct();
		order.getPayment();
		order.getTotalAmount();
		return orderRepository.save(order);
	}

	@Override
	public Order getAllOrders(String userEmail) throws OrderException {
		Users existingUser = userRepository.findByUserEmail(userEmail);
		if (existingUser != null) {
			Optional<Order> order = orderRepository.findById(existingUser.getOrders().getOrderId());
			Order existingOrder = order.get();
			return existingOrder;
		}
		throw new OrderException("Invalid user!");
	}
	
	

}
