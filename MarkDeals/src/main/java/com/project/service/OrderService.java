package com.project.service;

import com.project.model.Orders;

public interface OrderService {
	
	public Orders saveOrder(Orders orders,String email);

}
