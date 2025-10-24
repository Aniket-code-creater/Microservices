package com.user.service.UserService.services.impl;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.service.UserService.entity.Hotel;
import com.user.service.UserService.entity.Rating;
import com.user.service.UserService.entity.User;
import com.user.service.UserService.exceptions.ResourecNotFoundException;
import com.user.service.UserService.external.service.HotelService;
import com.user.service.UserService.repositories.UserRepositories;
import com.user.service.UserService.services.UserServices;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserServices{

	@Autowired
	private UserRepositories repositories;
	
	@Autowired(required = true)
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;
	
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return repositories.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return repositories.findAll();
	}

	@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		User user= repositories.findById(userId).orElseThrow(()-> new ResourecNotFoundException("user given id is not founnd on server..."));
		//get ratings from rating service for single user
		//http://localhost:8083/ratings/users/7ca8d48c-25af-48c9-b664-dfa0142d78ab
		Rating[] ratingsofUser=restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class)	;	
		
		List<Rating> list=Arrays.stream(ratingsofUser).collect(Collectors.toList());		
		
		log.info("{}",list);
		List<Rating> ratinglist=list.stream().map(ratings -> {
			//Api call to hotel service to get the hotel
			//http://localhost:8082/hotel/hotelId/5212cda6-dd3f-4b97-a3f4-6763873f1a0c
			ResponseEntity<Hotel> getEntity=restTemplate.getForEntity(hotelService.getSingleHotel(userId)+ratings.getHotelId(), Hotel.class);
			Hotel hotel=getEntity.getBody();
			log.info("Response status code :{}",getEntity.getStatusCode());
			ratings.setHotels(hotel);
			return ratings;
		}).collect(Collectors.toList());
		user.setRatings(ratinglist);
		
		return user;
	}

}
