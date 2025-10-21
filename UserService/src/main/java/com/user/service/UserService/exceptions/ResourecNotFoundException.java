package com.user.service.UserService.exceptions;

public class ResourecNotFoundException extends RuntimeException{

	public ResourecNotFoundException() {
		super("Resource not found !!");
	}
	public ResourecNotFoundException(String message) {
		super(message);
	}
}
