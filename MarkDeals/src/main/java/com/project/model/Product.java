package com.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	@NotNull(message = "Image url should not be null")
	private String imageUrl;
	@NotNull(message = "Product name should not be null")
	private String name;
	@NotNull(message = "Product price should not be null")
	private Integer price;
	@NotNull(message = "Product category should not be null")
	private String category;
	@NotNull(message = "Product rating should not be null")
	private String rating;
	@NotNull(message = "Product quantity should not be null")
	private Integer quantity;
	@NotNull(message = "Product description should not be null")
	private String description;

}
