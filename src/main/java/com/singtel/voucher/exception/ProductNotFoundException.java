package com.singtel.voucher.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public ProductNotFoundException() {
		super();
	}
	
	public ProductNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ProductNotFoundException(String message) {
		super(message);
	}
	
	public ProductNotFoundException(Throwable cause) {
		super(cause);
	}
}