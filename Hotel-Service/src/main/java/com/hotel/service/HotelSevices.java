package com.hotel.service;

import java.util.List;

import com.hotel.entity.Hotel;

public interface HotelSevices {

	public Hotel createHotel(Hotel hotel);
	
	public List<Hotel> getAllHotels();
	
	public Hotel getHotelById(String id);
}
