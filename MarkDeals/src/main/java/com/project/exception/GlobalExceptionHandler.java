package com.project.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.project.model.MyErrorDetails;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(AdminException.class)  
	public ResponseEntity<MyErrorDetails> adminExceptionHandler(AdminException adminException,WebRequest req){
        
		MyErrorDetails myErr = new MyErrorDetails(LocalDateTime.now(), adminException.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(myErr,HttpStatus.BAD_REQUEST);
	}
	

	@ExceptionHandler(UserException.class)  
	public ResponseEntity<MyErrorDetails> userExceptionHandler(UserException userException,WebRequest req){
        
		MyErrorDetails myErr = new MyErrorDetails(LocalDateTime.now(), userException.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(myErr,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ProductException.class)  
	public ResponseEntity<MyErrorDetails> productExceptionHandler(ProductException productException,WebRequest req){
        
		MyErrorDetails myErr = new MyErrorDetails(LocalDateTime.now(), productException.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(myErr,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(CartException.class)  
	public ResponseEntity<MyErrorDetails> cartExceptionHandler(CartException cartException,WebRequest req){
        
		MyErrorDetails myErr = new MyErrorDetails(LocalDateTime.now(), cartException.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(myErr,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(PaymentException.class)  
	public ResponseEntity<MyErrorDetails> paymentExceptionHandler(PaymentException paymentException,WebRequest req){
        
		MyErrorDetails myErr = new MyErrorDetails(LocalDateTime.now(), paymentException.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(myErr,HttpStatus.BAD_REQUEST);
	}
		
		
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> myExceptionHandler(Exception exception,WebRequest req){
		
		MyErrorDetails myErr = new MyErrorDetails(LocalDateTime.now(), exception.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(myErr,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> mynotFoundHandler(NoHandlerFoundException noHandlerFoundException,WebRequest req)  {
			
	
	MyErrorDetails myErr =new MyErrorDetails(LocalDateTime.now(), noHandlerFoundException.getMessage(), req.getDescription(false));
	
		return new ResponseEntity<>(myErr,HttpStatus.BAD_REQUEST);
					
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> methodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException,WebRequest req)  {
			
	
		MyErrorDetails myErr=new MyErrorDetails(LocalDateTime.now(), methodArgumentNotValidException.getBindingResult().getFieldError().getDefaultMessage(), req.getDescription(false));
	
		return new ResponseEntity<>(myErr,HttpStatus.BAD_REQUEST);
					
	}

}
