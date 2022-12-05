/**
 * 
 */
package com.mukul.user.service.exception;

/**
 * @author mukul
 *
 * 23-Nov-2022
 */
public class UsePatchInsteadOfPutException extends RuntimeException{

	public UsePatchInsteadOfPutException(String message) {
		super(message);
		
	}

}
