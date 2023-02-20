package com.project.service;

import java.time.LocalDate;
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
	public Order addOrder(Order order,Integer uId) throws OrderException {
		Optional<Users> optUser = userRepository.findById(uId);
		Users users = optUser.get();
		order.setStatus("Processing");
		order.setPlacedDate(LocalDate.now());
		users.getOrders().add(order);
		userRepository.save(users);
		return orderRepository.save(order);
	}

	@Override
	public List<Order> getAllOrders(String userEmail) throws OrderException {
		Users existingUser = userRepository.findByUserEmail(userEmail);
		if (existingUser != null) {
			List<Order> listOfOrders=  existingUser.getOrders();
			return listOfOrders;
		}
		throw new OrderException("Invalid user!");
	}
	
	

}
