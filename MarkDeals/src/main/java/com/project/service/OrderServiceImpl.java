package com.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.exception.OrderException;
import com.project.model.Order;
import com.project.model.ProductDto;
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
	public Order addOrder(Users users) throws OrderException {
		Optional<Order> order = orderRepository.findById(users.getOrder().getOrderId());
		Order existingOrder = order.get();
		existingOrder.getProduct().add((ProductDto) users.getCart().getProduct());
		existingOrder.setPayment(users.getOrder().getPayment());
		existingOrder.setTotalAmount(users.getOrder().getTotalAmount());
		return orderRepository.save(existingOrder);
	}

//	@Override
//	public List<Order> getAllOrders(String userEmail) throws OrderException {
//	return null;
//	}
	
	

}
