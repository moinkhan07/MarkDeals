package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.exception.ProductException;
import com.project.model.Product;
import com.project.service.ProductService;


@RestController
@CrossOrigin(origins = "*")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@PostMapping("/products")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) throws ProductException{
		Product addedProduct = productService.addProduct(product);
		return new ResponseEntity<>(addedProduct,HttpStatus.CREATED);
	}
	
	@PatchMapping("/products/{pId}")
	public ResponseEntity<Product> updateProduct(@RequestBody Integer updatedPrice,@PathVariable("pId") Integer pId) throws ProductException{
		Product updatedProduct = productService.updateProductPrice(pId,updatedPrice);
		return new ResponseEntity<>(updatedProduct,HttpStatus.OK);
	}
	
	@DeleteMapping("/products/{pId}")
	public ResponseEntity<Product> deleteProduct(@PathVariable("pId") Integer productId) throws ProductException{
		Product deletedProduct = productService.deleteProduct(productId);
		return new ResponseEntity<>(deletedProduct,HttpStatus.OK);
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> viewAllProducts() throws ProductException{
		List<Product> allProducts = productService.viewAllProducts();
		return new ResponseEntity<>(allProducts,HttpStatus.OK);
	}
	
	@GetMapping("/productsbycategory/{category}")
	public ResponseEntity<List<Product>> viewAllProductsByCategory(@PathVariable("category") String productCategory) throws ProductException{
		List<Product> allProductsByCategory = productService.viewAllProductsByCategory(productCategory);
		return new ResponseEntity<>(allProductsByCategory,HttpStatus.OK);
	}
	
	@GetMapping("/productbyname/{pName}")
	public ResponseEntity<List<Product>> viewProductByProductName(@PathVariable("pName") String productName) throws ProductException{
		List<Product> productByName = productService.viewProductByProductName(productName);
		return new ResponseEntity<List<Product>>(productByName, HttpStatus.OK);
	}
	
	@GetMapping("/sortinascending")
	public ResponseEntity<List<Product>> sortProductInLowToHighPrice() throws ProductException{
		List<Product> productsSortInAsc = productService.viewAllProductsByPriceInAscendingOrder();
		return new ResponseEntity<>(productsSortInAsc,HttpStatus.OK);
	}
	
	@GetMapping("/sortindescending")
	public ResponseEntity<List<Product>> sortProductInHighToLowPrice() throws ProductException{
		List<Product> productsSortInDesc = productService.viewAllProductsByPriceInDescendingOrder();
		return new ResponseEntity<>(productsSortInDesc,HttpStatus.OK);
	}
	
	@GetMapping("/productsbyrating/{productRating}")
	public ResponseEntity<List<Product>> viewAllProductsByRating(@PathVariable("productRating") String productRating ) throws ProductException{
		List<Product> productsByRating = productService.viewAllProductsByRating(productRating);
		return new ResponseEntity<>(productsByRating,HttpStatus.OK);
	}
	
	
	
}
