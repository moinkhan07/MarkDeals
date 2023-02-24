package com.project.service;

import java.util.List;

import com.project.model.Orders;

public interface OrderService {
	
	public Orders saveOrder(Orders orders,String email);

	public List<Orders> viewAllOrdersByUserEmail(String userEmail);
	
	public List<Orders> viewAllOrders();
	
	public Orders updateOrderStatus(Integer orderId,String updateStatus);
}
