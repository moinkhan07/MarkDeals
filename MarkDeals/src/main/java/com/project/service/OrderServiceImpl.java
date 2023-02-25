package com.project.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Orders;
import com.project.model.Product;
import com.project.model.Users;
import com.project.repository.OrderRepository;
import com.project.repository.ProductRepository;
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
			Double discountedAmt = prod.getPrice() / 10.0;
			finalPrice += (prod.getPrice() - discountedAmt);
		}
		orders.setOrderstatus("Processing");
		orders.setPlacedDate(LocalDate.now());
		finalPrice = finalPrice + 120.0 + (finalPrice * 1.0 / 100.0);
		orders.setTotalAmount(finalPrice);
		orders.setUsers(existingUser);
		existingUser.getOrders().add(orders);
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

	@Override
	public List<Product> getAllProductFromOrder(Integer orderId) {
		Optional<Orders> optOrders = orderRepository.findById(orderId);
		Orders existingOrder = optOrders.get();
		List<Product> listOfProducts = existingOrder.getProducts();
		return listOfProducts;
	}

	@Override
	public Double totalSalesToday() {
		List<Orders> listOfOrders = orderRepository.findAll();
		Double todaySales = 0.0;
		for (Orders orders : listOfOrders) {
			if (orders.getPlacedDate().equals(LocalDate.now())) {
				todaySales += orders.getTotalAmount();
			}
		}
		return todaySales;
	}

	@Override
	public Integer totalOrders() {
		List<Orders> listOfOrders = orderRepository.findAll();
		Integer totalOrders = 0;
		for (Orders orders : listOfOrders) {
			totalOrders++;
		}
		return totalOrders;
	}

	@Override
	public Integer totalProcessingOrders() {
		List<Orders> listOfOrders = orderRepository.findAll();
		Integer totalProcessingOrder = 0;
		for (Orders orders : listOfOrders) {
			if (orders.getOrderstatus() == "Processing") {
				totalProcessingOrder++;
			}
		}
		return totalProcessingOrder;
	}
	
	@Override
	public Integer totalProcessedOrders() {
		List<Orders> listOfOrders = orderRepository.findAll();
		Integer totalProcessedOrder = 0;
		for (Orders orders : listOfOrders) {
			if (orders.getOrderstatus() == "Processed") {
				totalProcessedOrder++;
			}
		}
		return totalProcessedOrder;
	}

	@Override
	public Integer totalOutForDeliveryOrders() {
		List<Orders> listOfOrders = orderRepository.findAll();
		Integer totalProcessingOrder = 0;
		for (Orders orders : listOfOrders) {
			if (orders.getOrderstatus() == "Out for delivery") {
				totalProcessingOrder++;
			}
		}
		return totalProcessingOrder;
	}

	@Override
	public Integer totalDeliveredOrders() {
		List<Orders> listOfOrders = orderRepository.findAll();
		Integer totalProcessingOrder = 0;
		for (Orders orders : listOfOrders) {
			if (orders.getOrderstatus() == "Delivered") {
				totalProcessingOrder++;
			}
		}
		return totalProcessingOrder;
	}

}
