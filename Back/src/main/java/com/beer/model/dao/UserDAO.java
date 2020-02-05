package com.beer.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.beer.model.dto.User;

@Mapper
public interface UserDAO {
	public User search(String userId);
	public List<User> searchAll();
	public boolean insert(User user);
	public boolean update(User user);
	public boolean delete(String userId);
	public List<User> searchByNickname(String nickname);
}
