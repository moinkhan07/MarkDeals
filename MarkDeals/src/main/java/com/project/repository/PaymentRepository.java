package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
