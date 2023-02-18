package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Payment;
import com.project.service.PaymentService;

@RestController
@CrossOrigin(origins = "*")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/savepayment")
	public ResponseEntity<Payment> savePayment(@RequestBody Payment payment){
		Payment savePaymentOfUser = paymentService.savePaymentOfUser(payment);
		return new ResponseEntity<Payment>(savePaymentOfUser,HttpStatus.CREATED);
	}

}
