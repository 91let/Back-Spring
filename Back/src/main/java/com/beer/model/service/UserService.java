package com.beer.model.service;

import java.util.List;

import com.beer.model.dto.User;

public interface UserService {

	User search(String userId);
	
	List<User> searchAll();

	boolean insert(User user);

	boolean update(User user);
	
	boolean delete(String userId);

	List<User> searchByNickname(String nickName);
}