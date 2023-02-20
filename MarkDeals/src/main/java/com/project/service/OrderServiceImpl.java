package com.project.service;

import java.util.List;
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
		return orderRepository.save(order);
	}

	@Override
	public List<Order> getAllOrders(Integer userId) throws OrderException {
		Optional<Users> optUser = userRepository.findById(userId);
		if (optUser.isEmpty()) {
			throw new OrderException("User does not exist");
		}else {
			Users existingUser = optUser.get();
			List<Order> orders = existingUser.getOrders();
			return orders;
		}
	}
	
	

}
