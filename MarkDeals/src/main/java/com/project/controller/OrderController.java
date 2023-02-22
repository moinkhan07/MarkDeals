package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.exception.OrderException;
import com.project.model.Order;
import com.project.model.Payment;
import com.project.model.Users;
import com.project.service.OrderService;

@RestController
@CrossOrigin(origins = "*")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
//	@PostMapping("/orders/{amt}/{uEmail}")
//	public ResponseEntity<Order> addOrder(@RequestBody Payment payment,@PathVariable("amt") Double amt,@PathVariable("uEmail") String userEmail)throws OrderException{
//		Order savedOrder = orderService.addOrder(userEmail,amt,payment);
//		return new ResponseEntity<Order>(savedOrder,HttpStatus.CREATED);
//	}
//	
//	@GetMapping("/orders/{uEmail}")
//	public ResponseEntity<List<Order>> getAllOrders(@PathVariable("uEmail") String userEmail) throws OrderException{
//		List<Order> orders = orderService.getAllOrders(userEmail);
//		return new ResponseEntity<>(orders,HttpStatus.OK);
//	}

}
