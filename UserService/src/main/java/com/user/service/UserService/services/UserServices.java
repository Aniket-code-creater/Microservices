package com.user.service.UserService.services;

import java.util.List;

import com.user.service.UserService.entity.User;

public interface UserServices {

	public User saveUser(User user);
	
	public List<User> getAllUser();
	
	public User getUser(String userId);
}
