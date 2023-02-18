package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Payment;
import com.project.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	
	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public Payment savePaymentOfUser(Payment payment) {
		return paymentRepository.save(payment);
	}

}
