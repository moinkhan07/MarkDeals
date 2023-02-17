package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.model.Cart;
import com.project.model.Product;
@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{
	
	public Cart findByCartId(Integer cartId);
	
	@Query("Delete from cart_product where cart_cart_id = ?1")
	public List<Product> deleteAllProductsFromCart(Integer cartId);
	
	

}
