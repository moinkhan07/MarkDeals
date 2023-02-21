package com.project.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class ProductDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productHistoryId;
	
	private String status = "Processing";
	
	private LocalDate placedDate = LocalDate.now();
	
	@OneToOne
	private Product product;

}
