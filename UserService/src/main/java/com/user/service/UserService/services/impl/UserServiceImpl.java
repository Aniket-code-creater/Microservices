package com.user.service.UserService.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.service.UserService.entity.User;
import com.user.service.UserService.exceptions.ResourecNotFoundException;
import com.user.service.UserService.repositories.UserRepositories;
import com.user.service.UserService.services.UserServices;

@Service
public class UserServiceImpl implements UserServices{

	@Autowired
	private UserRepositories repositories;
	
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
		return repositories.findById(userId).orElseThrow(()-> new ResourecNotFoundException("user given id is not founnd on server..."));
	}

}
