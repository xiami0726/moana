package com.movietickets.dao;

import com.movietickets.domain.User;

public interface UserDao {	
	int insert(String userName, String password, String email);
	
	boolean update(User user);
	
	User deleteUserByUserName(String userName);
	
	User deleteUserByEmail(String email);
	
	User selectByUserId(int id);
	
	User selectByUserName(String userName);
	
	User selectByEmail(String email);
	
}
