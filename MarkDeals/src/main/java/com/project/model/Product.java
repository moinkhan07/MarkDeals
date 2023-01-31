package com.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.catalina.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
