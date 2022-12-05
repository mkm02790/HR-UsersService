/**
 * 
 */
package com.mukul.user.service.impl;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mukul.user.service.entities.Hotel;
import com.mukul.user.service.entities.Rating;
import com.mukul.user.service.entities.User;
import com.mukul.user.service.exception.ResourceNotFoundException;
import com.mukul.user.service.repo.UserRepo;
import com.mukul.user.service.services.UserServices;

/**
 * @author mukul
 *
 *         19-Nov-2022
 */
@Service
public class UserServiceImpl implements UserServices {
	@Autowired
	UserRepo userRepo;

	@Autowired
	User user;

	@Autowired
	RestTemplate restTemplate;

	@Override
	public User saveUser(User us) {
		String randomID = UUID.randomUUID().toString().substring(0, 8);
		user.setUserId(randomID);
		user.setMobileNum(us.getMobileNum());
		user.setAbout(us.getAbout());
		user.setEmail(us.getEmail());
		user.setName(us.getName());

		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUser() {

		return userRepo.findAll();
	}

	@Override
	public User getUser(String userId) {
		User user = userRepo.findById(userId).orElseThrow(
				() -> new ResourceNotFoundException("User of Id " + userId + " is Not Present in database"));

		System.out.println("http://localhost:8003/ratings/users/" + user.getUserId());
		Rating[] userRatingsArray = restTemplate.getForObject("http://RATINGSERVICE/ratings/users/" + user.getUserId(),
				Rating[].class);

		List<Rating> userRatings = Arrays.stream(userRatingsArray).toList();
		for (Rating rating : userRatings) {
			Hotel hoteRating = restTemplate.getForObject("http://HOTELSERVICE/hotels/" + rating.getHotelId(),
					Hotel.class);
			System.out.println("http://localhost:8002/hotels/" + rating.getHotelId());
			rating.setHotel(hoteRating);

		}
		user.setRating(userRatings);
		return user;

	}

	@Override
	public User deleteUser(String userId) {
		User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException(
				"User Id " + userId + " is Not Present in database so Deletion operation can not be done"));
		userRepo.delete(user);
		return user;
	}

	@Override
	public User updateUser(User user) {
		User updatedUser = userRepo.findById(user.getUserId()).orElseThrow(() -> new ResourceNotFoundException(
				"User Id " + user.getUserId() + " is Not Present in database so Update operation can not be done"));
		updatedUser.setAbout(user.getAbout());
		updatedUser.setEmail(user.getEmail());
		updatedUser.setName(user.getName());
		updatedUser.setMobileNum(user.getMobileNum());
		userRepo.save(updatedUser);
		return updatedUser;
	}

	@Override
	public User updatePatch(User user) {
		User updatedUser = userRepo.findById(user.getUserId()).orElseThrow(() -> new ResourceNotFoundException(
				"User Id " + user.getUserId() + " is Not Present in database so Patch operation can not be done"));

		if (!(null == user.getAbout())) {
			updatedUser.setAbout(user.getAbout());
		}
		if (!(null == user.getEmail())) {
			updatedUser.setEmail(user.getEmail());
		}
		if (!(null == user.getName())) {
			updatedUser.setName(user.getName());
		}
		userRepo.save(updatedUser);
		return updatedUser;

	}

}
/*
 * if(!(null==user.getAbout() && user.getAbout().length()==0)) {
 * updatedUser.setAbout(user.getAbout()); }if(!(null==user.getEmail()&&
 * user.getEmail().length()==0)){ updatedUser.setEmail(user.getEmail());
 * }if(!(null==user.getName()&& user.getName().length()==0)){
 * updatedUser.setName(user.getName()); }
 */