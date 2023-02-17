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
	

}
