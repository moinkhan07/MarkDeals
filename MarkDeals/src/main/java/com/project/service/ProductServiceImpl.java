package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.exception.ProductException;
import com.project.model.Product;
import com.project.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) throws ProductException {
		return productRepository.save(product);
	}

	@Override
	public Product updateProductPrice(Integer pId, Integer updatedPrice) throws ProductException {
		Optional<Product> existingProduct = productRepository.findById(pId);
		if(existingProduct.isEmpty()) {
			throw new ProductException("Product does not exist!");
		}
		Product product = existingProduct.get();
		product.setPrice(updatedPrice);
		return productRepository.save(product);
	}
	

	@Override
	public Product updateProductQuantity(Integer pId, Integer updatedQuantity) throws ProductException {
		Optional<Product> existingProduct = productRepository.findById(pId);
		if(existingProduct.isEmpty()) {
			throw new ProductException("Product does not exist!");
		}
		Product product = existingProduct.get();
		product.setQuantity(product.getQuantity() + updatedQuantity);
		return productRepository.save(product);
	}

	@Override
	public Product deleteProduct(Integer pId) throws ProductException {
		Optional<Product> opt = productRepository.findById(pId);
		if (opt.isPresent()) {
			Product existingProduct = opt.get();
			productRepository.delete(existingProduct);
			return existingProduct;
		}
		throw new ProductException("Product does not exist with product Id " + pId);
	}

	@Override
	public List<Product> viewAllProducts() throws ProductException {
		List<Product> existingProducts = productRepository.getAllProducts();
		if (existingProducts == null) {
			throw new ProductException("Products does not exist");
		}
		return existingProducts;
	}

	@Override
	public List<Product> viewAllProductsByCategory(String productCategory) throws ProductException {
		List<Product> existingProductsByCategory = productRepository.findByCategory(productCategory);
		if (existingProductsByCategory == null) {
			throw new ProductException("Products does not exist with product category " + productCategory);
		}
		return existingProductsByCategory;
	}

	@Override
	public List<Product> viewProductByProductName(String productName) throws ProductException {
		List<Product> existingProduct = productRepository.findByProductName(productName);
		if (existingProduct == null) {
			throw new ProductException("Product does not exist with product name " + productName);
		}
		return existingProduct;
	}

	@Override
	public List<Product> viewAllProductsByPriceInAscendingOrder() throws ProductException {
		List<Product> ascendingProducts = productRepository.getAllProductsByPriceInAscendingOrder();
		if (ascendingProducts == null) {
			throw new ProductException("Products does not exist");
		}
		return ascendingProducts;
	}

	@Override
	public List<Product> viewAllProductsByPriceInDescendingOrder() throws ProductException {
		List<Product> descendingProducts = productRepository.getAllProductsByPriceInDescendingOrder();
		if (descendingProducts == null) {
			throw new ProductException("Products does not exist");
		}
		return descendingProducts;
	}

	@Override
	public List<Product> viewAllProductsByRating(String productRating) throws ProductException {
		List<Product> productsByRating = productRepository.findByRating(productRating);
		if (productRating == null) {
			throw new ProductException("Product does not exist with product rating " + productRating);
		}
		return productsByRating;
	}

	@Override
	public Integer totalNumberOfProducts() {
		List<Product> listOfProducts = productRepository.findAll();
		Integer totalProductsCounter = 0;
		for (Product product : listOfProducts) {
			totalProductsCounter++;
		}
		return totalProductsCounter;
	}


}
