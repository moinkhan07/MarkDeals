package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.ProductDto;

public interface ProductDtoRepository extends JpaRepository<ProductDto, Integer>{

}
