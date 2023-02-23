package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Orders;
@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>{

}
