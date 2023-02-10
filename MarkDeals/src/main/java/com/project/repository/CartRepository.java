package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Cart;
@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{
	
	public Cart findByCartId(Integer cartId);
	

}
