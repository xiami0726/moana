package com.movietickets.dao.impl.test;

import org.junit.Test;

import com.movietickets.dao.impl.UserDaoImpl;
import com.movietickets.domain.User;

public class UserDaoImplTest {

	@Test
	public void userTest(){
		User user = new User();
		user.setUserId(129);
		user.setUserName("ld0730");
		user.setEmail("723670997@qq.com");
		user.setPassword("123456");
		
//		UserDaoImpl.insert("ld08004","654321", "723670997@qq.com");
		UserDaoImpl impl = new UserDaoImpl();
		impl.update(user);
		impl.deleteUserByUserName("156");
//		user = impl.selectByUserId(123);
//		System.out.println(user);
		
//		impl.update(user);
//		impl.insert(user);
//		User user2 = impl.selectByUserId(18);
//		User user2 = impl.selectByUserName("ld");
		
//		User user2 = impl.selectByEmail("723670997@qq.com");
//		User user2 = impl.deleteUserByEmail("723670997@qq.com");
		
//		System.out.println(" user2 = " + user2);
		
	}
}
