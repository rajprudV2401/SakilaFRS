package com.cg.sakila.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//for all exceptions
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<String> handleCustomerNotFoundException(CustomerNotFoundException cnfe){
		ResponseEntity<String> res=new ResponseEntity<String>(cnfe.getMessage(),HttpStatus.NOT_FOUND);
		return res;
	}
	
	@ExceptionHandler(ActorNotFoundException.class)
	public ResponseEntity<String> handleActorNotFoundException(ActorNotFoundException anfe){
		ResponseEntity<String> res=new ResponseEntity<String>(anfe.getMessage(),HttpStatus.NOT_FOUND);
		return res;
	}
}
