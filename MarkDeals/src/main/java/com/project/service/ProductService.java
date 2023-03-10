package com.project.service;

import java.util.List;

import com.project.exception.ProductException;
import com.project.model.Product;


public interface ProductService {
	
	public Product addProduct(Product product) throws ProductException;
	
	public Product updateProductPrice(Integer pId, Integer updatedPrice) throws ProductException;

	public Product updateProductQuantity(Integer pId, Integer updatedQuantity) throws ProductException;
	
	public Product deleteProduct(Integer pId) throws ProductException;
	
	public List<Product> viewAllProducts() throws ProductException;
	
	public List<Product> viewAllProductsByCategory(String productCategory) throws ProductException;
	
	public List<Product> viewProductByProductName(String productName) throws ProductException;
	
	public List<Product> viewAllProductsByPriceInAscendingOrder() throws ProductException;
	
	public List<Product> viewAllProductsByPriceInDescendingOrder() throws ProductException;
	
	public List<Product> viewAllProductsByRating(String productRating) throws ProductException; 
	
	public Integer totalNumberOfProducts();
	

}
