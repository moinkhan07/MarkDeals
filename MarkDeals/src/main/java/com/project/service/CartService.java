package com.project.service;

import java.util.List;

import com.project.exception.CartException;
import com.project.model.Cart;
import com.project.model.Product;
import com.project.model.Users;

public interface CartService {
	
	public Cart addProductToCart(Integer pid, Users users)throws CartException;
	
	public List<Product> viewAllProductByCartId(String userEmail) throws CartException;
		

}
