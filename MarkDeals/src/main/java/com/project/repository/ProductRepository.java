package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	@Query("from Product where name like %:name%")
	public List<Product> findByProductName(@Param("name") String name);
	
	public Product findByName(String name);
	
	@Query("from Product")
	public List<Product> getAllProducts();
	
	public List<Product> findByCategory(String category);
	
	@Query("from Product order by price ASC")
	public List<Product> getAllProductsByPriceInAscendingOrder();
	
	@Query("from Product order by price DESC")
	public List<Product> getAllProductsByPriceInDescendingOrder();
	
	public List<Product> findByRating(String rating);

}
