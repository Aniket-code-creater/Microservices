package com.ratring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ratring.entity.Rating;

@Service
public interface RatingService {

	public Rating createRating(Rating rating);
	
	public List<Rating> findByUserId(String Id);
	
	public List<Rating> findAll();
	
	public List<Rating> getRatingByHotelId(String hotelId);
	
	
}
