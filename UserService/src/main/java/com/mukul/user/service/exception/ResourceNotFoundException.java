/**
 * 
 */
package com.mukul.user.service.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author mukul
 *
 * 19-Nov-2022
 */

public class ResourceNotFoundException extends RuntimeException {

	
	public ResourceNotFoundException() {
		super();
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
		
	}

	

}
