package com.project.model;

import org.springframework.validation.annotation.Validated;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Validated
public class Address {
		
	@NotNull(message = "City should not be null")
	private String city;
	
	@NotNull(message =  "state should not be null")
	private String state;
	
	@NotNull(message = "Country should not be null")
	private String country;
	
	@NotNull(message = "Pincode should be of 6 digits")
	@Size(min = 6,max = 6)
	private String pincode;
	
}
