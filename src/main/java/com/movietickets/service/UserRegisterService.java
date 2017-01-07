package com.movietickets.service;

import com.movietickets.domain.User;

public interface UserRegisterService {
	boolean register(String userName, String password, String email);
}
