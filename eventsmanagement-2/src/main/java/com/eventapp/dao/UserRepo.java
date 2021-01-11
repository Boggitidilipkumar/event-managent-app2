package com.eventapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventapp.entity.User;
@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	public User findByUsername(String username);
}
