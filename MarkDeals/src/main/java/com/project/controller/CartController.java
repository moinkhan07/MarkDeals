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

import com.project.exception.CartException;
import com.project.model.Cart;
import com.project.model.Product;
import com.project.model.Users;
import com.project.service.CartService;

@RestController
@CrossOrigin
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/addtocart/{pid}")
	public ResponseEntity<Cart> addProductToCart(@PathVariable("pid") Integer pid,@RequestBody Users users) throws CartException{
		Cart addedProduct = cartService.addProductToCart(pid, users);
		return new ResponseEntity<Cart>(addedProduct,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/cartproducts/{uEmail}")
	public ResponseEntity<List<Product>> getAllProducts(@PathVariable("uEmail") String userEmail) throws CartException{
		List<Product> listOfProductsInTheCartByUserId = cartService.viewAllProductByCartId(userEmail);
		return new ResponseEntity<List<Product>>(listOfProductsInTheCartByUserId,HttpStatus.OK);
	}

}
