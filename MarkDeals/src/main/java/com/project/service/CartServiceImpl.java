package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.exception.CartException;
import com.project.model.Cart;
import com.project.model.Product;
import com.project.model.Users;
import com.project.repository.CartRepository;
import com.project.repository.ProductRepository;
import com.project.repository.UserRepository;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Cart addProductToCart(Integer pid, Users users) throws CartException {
	     Cart cart = cartRepository.findByCartId((users.getCart()).getCartId());
	     Optional<Product> optProduct = productRepository.findById(pid);
	     Product product = optProduct.get();
		 cart.getProduct().add(product);
		 return cartRepository.save(cart);
	}

	@Override
	public List<Product> viewAllProductByCartId(String userEmail) throws CartException {
		Users users= userRepository.findByUserEmail(userEmail);
		if (users != null) {
		Cart cart = cartRepository.findByCartId(users.getCart().getCartId());
		List<Product> listOfProductsInCart = cart.getProduct();
		return listOfProductsInCart;
		}else {
			throw new CartException("No Such Cart exist!");
		}
	}

	@Override
	public List<Product> deleteAllProductsFromUserCart(Integer cartId) throws CartException {
		Optional<Cart> optCart = cartRepository.findById(cartId);
		if (optCart.isEmpty()) {
			throw new CartException("No such cart is exist!");
		}else {
			Cart existingCart = optCart.get();
			List<Product> listOProducts = existingCart.getProduct();
			for (int i = 0; i < listOProducts.size(); i++) {
				listOProducts.remove(i);
			}
			cartRepository.save(existingCart);
			return listOProducts;
		}
	}

	

}
