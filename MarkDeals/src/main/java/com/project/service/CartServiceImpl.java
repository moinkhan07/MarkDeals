package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.exception.CartException;
import com.project.model.Cart;
import com.project.model.Product;
import com.project.model.Users;
import com.project.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepository cartRepository;

	@Override
	public Cart addProductToCart(Product product, Users users) throws CartException {
		Cart cart = cartRepository.findByUsers(users.getUserId());
		
		if (cart == null) {
			throw new CartException("Cart is empty!");
		}else{
			cart.getProduct().add(product);
			return cart;
		}
	}

}
