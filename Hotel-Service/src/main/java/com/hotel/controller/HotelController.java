package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.entity.Hotel;
import com.hotel.service.HotelSevices;

@RestController
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private HotelSevices hotelSevices;
	
	@PostMapping("/createHotel")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		Hotel hotel1=	this.hotelSevices.createHotel(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
	}
	
	@GetMapping("/hotelId/{id}")
	public ResponseEntity<Hotel> getSingleHotel(@PathVariable String id){
		Hotel hotel = this.hotelSevices.getHotelById(id);
		return ResponseEntity.ok(hotel);
	}
	
	@GetMapping("/getallHotels")
	public ResponseEntity<List<Hotel>> getAllHotel(){
		List<Hotel> hotels = this.hotelSevices.getAllHotels();
		return ResponseEntity.ok(hotels);
	}
}
