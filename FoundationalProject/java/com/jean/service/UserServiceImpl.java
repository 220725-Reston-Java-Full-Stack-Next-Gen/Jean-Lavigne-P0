package com.jean.service;


import org.apache.log4j.Logger;

import com.jean.daos.UserDao;
import com.jean.daos.UserDaoImpl;
import com.jean.models.User;

public class UserServiceImpl implements UserService {

	private static Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

	// because we depend on our dao layer here, we will need an instance of it
	// everything we need a new UserServiceImpl object
	private UserDao userDao;

	public UserServiceImpl(UserDaoImpl userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public int register(User user) {

		// 1. log event start
		LOGGER.info("In UserServiceImpl - register() started. New user: " + user);

		// 2. make my DB call
		int id = userDao.insertUser(user);

		// 3. log event end
		LOGGER.info("In UserServiceImpl - register() ended. New user id: " + id);

		// 4. return data in return statement
		return id;
	}

	@Override
	public boolean login(String username, String password) {
		// 1. log event start
		LOGGER.info("In UserServiceImpl - login() started. Credentials: Username=" + username + ", Password=" + password);

		// 2. make my DB call
		User target = userDao.selectUserByUsername(username);

		// 3. check if password & username matches DB info
		if (username.equalsIgnoreCase(target.getUsername()) && password.equalsIgnoreCase(target.getPassword())) {
		// 3. log event end
		LOGGER.info("In UserServiceImpl - login() ended. Credentials match!");
		return true;
		}

		// 4. return data in return statement
		LOGGER.warn("In UserServiceImpl - login() ended. Username and/or password do not match DB information.");

		return false;
	}

	public User getUserByUsername(String username) {
		//1. log event start
		LOGGER.info("In UserServiceImpl - getUserByUsername() started. Username: " + username);
				
		//2. make my DB call
		User target = userDao.selectUserByUsername(username);
				
		//3. log event end
		LOGGER.info("In UserServiceImpl - getUserByUsername() ended. Found user: " + target);
				
		//4. return data in return statement
		return target;
	}

}
