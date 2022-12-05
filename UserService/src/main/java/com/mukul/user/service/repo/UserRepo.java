/**
 * 
 */
package com.mukul.user.service.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mukul.user.service.entities.User;

/**
 * @author mukul
 *
 * 19-Nov-2022
 */
public interface UserRepo extends JpaRepository<User, String>{

	
}
