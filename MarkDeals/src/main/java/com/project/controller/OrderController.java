package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.exception.OrderException;
import com.project.model.Order;
import com.project.service.OrderService;

@RestController
@CrossOrigin(origins = "*")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/orders")
	public ResponseEntity<Order> addOrder(@RequestBody Order order)throws OrderException{
		Order savedOrder = orderService.addOrder(order);
		return new ResponseEntity<Order>(savedOrder,HttpStatus.CREATED);
	}
	
	@GetMapping("/orders/{uId}")
	public ResponseEntity<Order> getAllOrders(@PathVariable("uId") Integer uId) throws OrderException{
		Order orders = orderService.getAllOrders(uId);
		return new ResponseEntity<Order>(orders,HttpStatus.OK);
	}

}
