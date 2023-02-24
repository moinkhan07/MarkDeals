package com.project.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Orders;
import com.project.model.Product;
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
	public Orders saveOrder(Orders orders,String userEmail) {
		Double finalPrice = 0.0;
		Users existingUser = userRepository.findByUserEmail(userEmail);
		List<Product> listOfProducts =  existingUser.getCart().getProduct();		
		for (Product prod : listOfProducts) {
			orders.getProducts().add(prod);
			finalPrice += prod.getPrice();
		}
		orders.setOrderstatus("Processing");
		orders.setPlacedDate(LocalDate.now());
		orders.setTotalAmount(finalPrice);
		orders.setUsers(existingUser);
		existingUser.getOrders().add(orders);
		userRepository.save(existingUser);
		return orderRepository.save(orders);
	}

	@Override
	public List<Orders> viewAllOrdersByUserEmail(String userEmail) {
		Users existingUsers = userRepository.findByUserEmail(userEmail);
		List<Orders> listOfOrders = existingUsers.getOrders();
		return listOfOrders;
	}

	@Override
	public List<Orders> viewAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public Orders updateOrderStatus(Integer orderId,String updateStatus) {
		Optional<Orders> optOrders = orderRepository.findById(orderId);
		Orders existingOrder = optOrders.get();
		existingOrder.setOrderstatus(updateStatus);
		orderRepository.save(existingOrder);
		return existingOrder;
	}

}
