package com.user.service.UserService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.service.UserService.entity.User;

public interface UserRepositories extends JpaRepository<User, String> {

}
