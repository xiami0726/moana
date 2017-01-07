package com.movietickets.service.impl.test;

import org.junit.Test;

import com.movietickets.domain.User;
import com.movietickets.service.UserRegisterService;
import com.movietickets.service.impl.UserRegisterServiceImpl;

public class UserRegisterServiceImplTest {
	@Test
	public void functionTest(){
		UserRegisterService urs= new UserRegisterServiceImpl();
//		User user = new User();
//		user.setUserId(14);
//		user.setUserName("lid");
//		user.setEmail("72367@qq.com");
//		user.setPassword("123456");
		
		urs.register("lid0728", "123456", "723670997@qq.com");
		
		
	}
}
