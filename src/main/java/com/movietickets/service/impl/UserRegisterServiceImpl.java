package com.movietickets.service.impl;

import com.movietickets.dao.impl.UserDaoImpl;
import com.movietickets.domain.User;
import com.movietickets.service.UserRegisterService;

public class UserRegisterServiceImpl implements UserRegisterService {
	
//	private UserDao userDao = new UserDaoImpl();
	
	@Override
	public boolean register(String userName, String password, String email){
		UserDaoImpl userDao = new UserDaoImpl();
		
		User user1 = userDao.selectByEmail(email);
		User user2 = userDao.selectByUserName(userName);
		
		if (user1 == null && user2 == null){
			User user = new User();
			user.setUserId(1);
	        user.setEmail(email);
	        user.setPassword(password);
	        user.setUserName(userName);
	        
	        
	        userDao.insert(user);	
	        return true;
		} else {
			return false;
		}	
	}
}
