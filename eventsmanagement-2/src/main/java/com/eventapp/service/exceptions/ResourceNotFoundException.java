package com.eventapp.service.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -1725968727630693676L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
	

}
