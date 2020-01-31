package com.beer.model.service;

import java.util.List;

import com.beer.model.dto.User;

public interface UserService {

	User search(String userId);
	
	List<User> searchAll();

	void insert(User user);

	void update(User user);
	
	public void delete(String userId);

}
