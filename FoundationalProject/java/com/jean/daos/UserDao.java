package com.jean.daos;

import java.util.List;

import com.jean.models.User;

public interface UserDao {
	// crud methods
	// create
	public int insertUser(User user);

	public User selectUserByUsername(String username);

	public List<User> selectAllUsers();

	public void updateUser(User user);

	public void updatePassword(String username, String password);

	public Boolean deleteUser(int userId);

}
