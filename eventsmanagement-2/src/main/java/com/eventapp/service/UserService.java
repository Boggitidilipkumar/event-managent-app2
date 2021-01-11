package com.eventapp.service;

import com.eventapp.entity.User;

public interface UserService {
	public void addUser(User user);
	public User findByUsername(String username);

}
