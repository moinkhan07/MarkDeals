package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.exception.OrderException;
import com.project.model.Order;
import com.project.model.Payment;
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
	public Order addOrder(String userEmail,Double amt,Payment payment) throws OrderException {
		Users users = userRepository.findByUserEmail(userEmail);
		Order order = orderRepository.findByOrderId(users.getOrder().getOrderId());
		order.setProduct(users.getCart().getProduct());
		order.setStatus("Processing");
		order.setTotalAmount(amt);
		order.setPayment(payment);
		return orderRepository.save(order);
	}

//	@Override
//	public List<Order> getAllOrders(String userEmail) throws OrderException {
//	return null;
//	}
	
	

}
