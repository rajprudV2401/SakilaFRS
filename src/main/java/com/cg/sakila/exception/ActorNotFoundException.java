package com.cg.sakila.exception;

public class ActorNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ActorNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	public ActorNotFoundException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
}
