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
import com.project.service.OrderService;

@RestController
@CrossOrigin(origins = "*")
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@PostMapping("order/{uEmail}")
	public ResponseEntity<Order> addOrder(@RequestBody Order order, @PathVariable("uEmail") String uEmail) throws OrderException{
		Order addedOrder  = orderService.addOrder(order, uEmail);
		return new ResponseEntity<Order>(addedOrder,HttpStatus.CREATED);
	}

}
