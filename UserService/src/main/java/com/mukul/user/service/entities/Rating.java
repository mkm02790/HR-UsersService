/**
 * 
 */
package com.mukul.user.service.entities;

/**
 * @author mukul
 *
 * 23-Nov-2022
 */
public class Rating {

	private String ratingId;
	private String userId;
	private String hotelId;
	private double rating ;
	private String feedback;
	private Hotel hotel;
	public Rating(String ratingId, String userId, String hotelId, double rating, String feedback ,Hotel hotel) {
		super();
		this.ratingId = ratingId;
		this.userId = userId;
		this.hotelId = hotelId;
		this.rating = rating;
		this.feedback = feedback;
		this.hotel=hotel;
	}
	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getRatingId() {
		return ratingId;
	}
	public void setRatingId(String ratingId) {
		this.ratingId = ratingId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	
}
