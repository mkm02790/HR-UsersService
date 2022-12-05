/**
 * 
 */
package com.mukul.user.service.services;

import java.util.List;

import com.mukul.user.service.entities.User;

/**
 * @author mukul
 *
 * 19-Nov-2022
 */
public interface UserServices {

	User saveUser(User user);
	
	List<User> getAllUser();
	
	User getUser(String userId);
	
	User deleteUser(String user);
	
	User updateUser(User user);
	
	User updatePatch(User obj);
}
