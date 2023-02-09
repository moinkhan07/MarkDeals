package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.exception.CartException;
import com.project.model.Cart;
import com.project.model.Product;
import com.project.model.Users;
import com.project.service.CartService;

@RestController
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/addtocart")
	public ResponseEntity<Cart> addProductToCart(@RequestBody Product product,@RequestBody Users users) throws CartException{
		Cart addedProduct = cartService.addProductToCart(product, users);
		return new ResponseEntity<Cart>(addedProduct,HttpStatus.CREATED);
	}

}
