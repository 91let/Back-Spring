package com.beer.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.beer.model.dto.User;

@Mapper
public interface UserDAO {
	public User search(String userId);
	public List<User> searchAll();
	public void insert(User user);
	public void update(User user);
	public void delete(String userId);
}
