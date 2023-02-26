package com.project.service;

import java.util.List;

import com.project.model.Orders;
import com.project.model.Product;

public interface OrderService {
	
	public Orders saveOrder(Orders orders,String email);

	public List<Orders> viewAllOrdersByUserEmail(String userEmail);
	
	public List<Orders> viewAllOrders();
	
	public Orders updateOrderStatus(Integer orderId,String updateStatus);
	
	public List<Product> getAllProductFromOrder(Integer orderId);
	
	public Double totalSalesToday();
	
	public Double totalWeeklySales();
	
	public Double totalMonthlySales();
	
	public Integer totalOrders();
	
	public Integer totalProcessingOrders();
	
	public Integer totalProcessedOrders();
	
	public Integer totalOutForDeliveryOrders();
	
	public Integer totalDeliveredOrders();
	
	public Integer totalCancelledOrder();
	
	public String cancelOrder(Integer orderId);
	
}
