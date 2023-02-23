package com.project.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	
	private LocalDate placedDate;
	
	private String orderstatus;
	
	private Double totalAmount;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Product> products = new ArrayList<>();

	@ManyToOne(cascade = CascadeType.ALL)
	private Users users;

}
