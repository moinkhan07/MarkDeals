package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Orders;
import com.project.service.OrderService;

@RestController
@CrossOrigin(origins = "*")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/orders/{uEmail}")
	public ResponseEntity<Orders> saveOrders(@RequestBody Orders orders, @PathVariable("uEmail") String userEmail){
	    Orders savedOrder = orderService.saveOrder(orders, userEmail);
		return new ResponseEntity<Orders>(savedOrder,HttpStatus.OK);
	}
	
	@GetMapping("/orders")
	public ResponseEntity<List<Orders>> getAllOrderOfAUser(@PathVariable("uEmail") String uEmail){
		List<Orders> listOfOrders = orderService.viewAllOrdersByUserEmail(uEmail);
		return new ResponseEntity<List<Orders>>(listOfOrders,HttpStatus.OK);
	}

}
