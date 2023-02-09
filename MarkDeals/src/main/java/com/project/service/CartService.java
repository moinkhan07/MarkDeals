package com.project.service;

import com.project.exception.CartException;
import com.project.model.Cart;
import com.project.model.Product;
import com.project.model.Users;

public interface CartService {
	
	public Cart addProductToCart(Product product, Users users)throws CartException;
		

}
