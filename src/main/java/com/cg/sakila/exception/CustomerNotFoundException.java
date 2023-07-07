package com.cg.sakila.exception;

public class CustomerNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//if customer is not giving any input then we get this exception
	public CustomerNotFoundException() {
		
	}
	public CustomerNotFoundException(String msg) {
		super(msg);
	}
	
}
