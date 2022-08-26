package com.jean.service;

import com.jean.models.User;

public interface UserService {

	public int register(User user);	
	
	public boolean login(String username, String password);
	
	public User getUserByUsername(String username);
	
}
