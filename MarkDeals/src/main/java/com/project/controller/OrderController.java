package com.project.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Orders;
import com.project.model.Product;
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
	
	@GetMapping("/orders/{uEmail}")
	public ResponseEntity<List<Orders>> getAllOrderOfAUser(@PathVariable("uEmail") String uEmail){
		List<Orders> listOfOrders = orderService.viewAllOrdersByUserEmail(uEmail);
		return new ResponseEntity<List<Orders>>(listOfOrders,HttpStatus.OK);
	}
	
	@GetMapping("/orders")
	public ResponseEntity<List<Orders>> getAllOrders(){
		List<Orders> listOfOrders = orderService.viewAllOrders();
		return new ResponseEntity<List<Orders>>(listOfOrders,HttpStatus.OK);
	}
	
	@PatchMapping("/orders/{oId}/{updateStatus}")
	public ResponseEntity<Orders> updateOrderStatus(@PathVariable("oId") Integer orderId,@PathVariable("updateStatus") String updateStatus){
		Orders updatedOrders = orderService.updateOrderStatus(orderId, updateStatus);
		return new ResponseEntity<Orders>(updatedOrders,HttpStatus.OK);
	}
	
	@GetMapping("/ordersproducts/{orderId}")
	public ResponseEntity<List<Product>> getAllProductOfAOrder(@PathVariable("orderId") Integer orderId){
		List<Product> listOfProducts = orderService.getAllProductFromOrder(orderId);
		return new ResponseEntity<List<Product>>(listOfProducts,HttpStatus.OK);
	}
	
	@GetMapping("/orders/totalsalestoday")
	public ResponseEntity<Double> totalSalesToday(){
		Double totalSales = orderService.totalSalesToday();
		return new ResponseEntity<Double>(totalSales,HttpStatus.OK);
	}
	
	@GetMapping("/orders/totalorders")
	public ResponseEntity<Integer> totalOrders(){
		Integer totalOrders = orderService.totalOrders();
		return new ResponseEntity<Integer>(totalOrders,HttpStatus.OK);
	}

	@GetMapping("/orders/totalprocessingorders")
	public ResponseEntity<Integer> totalProcessingOrders(){
		Integer totalProcessingOrders = orderService.totalProcessingOrders();
		return new ResponseEntity<Integer>(totalProcessingOrders,HttpStatus.OK);
	}
	
	@GetMapping("/orders/totalprocessedorders")
	public ResponseEntity<Integer> totalProcessedOrders(){
		Integer totalProcessedOrders = orderService.totalProcessedOrders();
		return new ResponseEntity<Integer>(totalProcessedOrders,HttpStatus.OK);
	}
	
	@GetMapping("/orders/totaloutfordeliveryorders")
	public ResponseEntity<Integer> totalOutForDeliveryOrders(){
		Integer totalOFDOrders = orderService.totalOutForDeliveryOrders();
		return new ResponseEntity<Integer>(totalOFDOrders,HttpStatus.OK);
	}
	
	@GetMapping("/orders/totaldeliveredorders")
	public ResponseEntity<Integer> totalDeliveredOrders(){
		Integer totalDeliveredOrders = orderService.totalDeliveredOrders();
		return new ResponseEntity<Integer>(totalDeliveredOrders,HttpStatus.OK);
	}
	
	@GetMapping("/orders/totalcancelledorders")
	public ResponseEntity<Integer> totalCancelledOrder(){
		Integer totalCancelledOrder = orderService.totalCancelledOrder();
		return new ResponseEntity<Integer>(totalCancelledOrder,HttpStatus.OK);
	}
	
	
	@PatchMapping("/orders/{oId}")
	public ResponseEntity<String> cancelledOrder(@PathVariable("oId") Integer orderId){
		String cancelledOrder = orderService.cancelOrder(orderId);
		return new ResponseEntity<String>(cancelledOrder,HttpStatus.OK);
	}
	
	
	
	
	
}
