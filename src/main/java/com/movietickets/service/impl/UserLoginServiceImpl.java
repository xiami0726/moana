package com.movietickets.service.impl;

import com.movietickets.dao.impl.UserDaoImpl;
import com.movietickets.domain.User;
import com.movietickets.service.UserLoginService;

public class UserLoginServiceImpl implements UserLoginService {

	@Override
	public boolean login(String userName, String password, String email) {
		UserDaoImpl userDao = new UserDaoImpl();
		User user1 = userDao.selectByEmail(email);
		User user2 = userDao.selectByUserName(userName);
		
//		if (user1 != null )
//			System.out.println("user1 = " + user1 + " " + user1.getPassword() +" " + password);
//		
//		if (user2 != null)
//			System.out.println("user2 = " + user2 + " " + user2.getPassword() +" " + password);
		
		if (user1 != null && (user1.getPassword().equals(password))){
	        return true;
		} else if (user2 != null && (user2.getPassword().equals(password))){
			return true;
		} else {
			return false;
		}
		
	}

}
