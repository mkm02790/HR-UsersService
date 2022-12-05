/**
 * 
 */
package com.mukul.user.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mukul.user.service.entities.User;
import com.mukul.user.service.exception.UsePatchInsteadOfPutException;
import com.mukul.user.service.services.UserServices;

/**
 * @author mukul
 *
 *         22-Nov-2022
 */
@RestController
@RequestMapping("/users")
public class Controller {

	@Autowired
	UserServices userServices;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> createUser(@RequestBody User user) {

		User response = userServices.saveUser(user);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<List<User>> getAllUser(){
		List<User> userList =userServices.getAllUser();
		return new ResponseEntity<>(userList , HttpStatus.OK);
		}
   
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable String userId){
		User user = userServices.getUser(userId);
		return new ResponseEntity<>(user ,HttpStatus.OK);
		}
	
	@RequestMapping(method =RequestMethod.DELETE ,value ="/{userId}")
	public ResponseEntity<Object> deleteUser(@PathVariable String userId){
		User user = userServices.deleteUser(userId);
		return  ResponseEntity.status(HttpStatus.OK).body(user);		
	}
	
	@RequestMapping(method =RequestMethod.PUT )
	public ResponseEntity<User> updatePutUser (@RequestBody User obj){
		if(null==obj.getAbout() || null== obj.getEmail() || null== obj.getName()) {
		throw new UsePatchInsteadOfPutException("If only some fields need to update then use Patch method");
		}
		User user = userServices.updateUser(obj);
		return new ResponseEntity<User>(user ,HttpStatus.OK);
		}
	
	@RequestMapping(method =RequestMethod.PATCH )
	public ResponseEntity<User> updatePatchUser (@RequestBody User obj){
		User user = userServices.updatePatch(obj);
		return new ResponseEntity<User>(user ,HttpStatus.OK);
		}
	
}
