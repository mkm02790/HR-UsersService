/**
 * 
 */
package com.mukul.user.service.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/**
 * @author mukul
 *
 * 20-Nov-2022
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String ,Object>> handlerResourceNotFoundException(ResourceNotFoundException res){
	String message =res.getMessage();
	HashMap hm = new HashMap();
	hm.put("Status", HttpStatus.NOT_FOUND);
	hm.put("message",res.getMessage());
	hm.put("success", false);
	return new ResponseEntity<>(hm,HttpStatus.NOT_FOUND);				}

 @ExceptionHandler(UsePatchInsteadOfPutException.class)
  public ResponseEntity<Map<String ,Object>>  usePatchInsteadOfPutException(UsePatchInsteadOfPutException res){
	 String message =res.getMessage();
		HashMap hm = new HashMap();
		hm.put("Status", HttpStatus.BAD_REQUEST);
		hm.put("message",res.getMessage());
		hm.put("success", false);
		return new ResponseEntity<>(hm,HttpStatus.BAD_REQUEST);
	}
 
 
}