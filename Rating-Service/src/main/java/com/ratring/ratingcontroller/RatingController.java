package com.ratring.ratingcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratring.entity.Rating;
import com.ratring.services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	@PostMapping("/create")
	public ResponseEntity<Rating> CreateRating(@RequestBody Rating rating) {
		Rating response=ratingService.createRating(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);		
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
		List<Rating> ratings=ratingService.findByUserId(userId);
		return ResponseEntity.ok(ratings);
	}
	
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
		List<Rating> ratings=ratingService.getRatingByHotelId(hotelId);
		return ResponseEntity.ok(ratings);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Rating>> getAllRatings(){
		List<Rating> ratings=ratingService.findAll();
		return ResponseEntity.ok(ratings);
	}
	
}
