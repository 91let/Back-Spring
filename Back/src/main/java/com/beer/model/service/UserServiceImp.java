package com.beer.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beer.model.dao.UserDAO;
import com.beer.model.dto.User;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	private UserDAO dao;
	/* (non-Javadoc)
	 * @see com.beer.model.service.UserService#search(java.lang.String)
	 */
	@Override
	public User search(String userId) {
		try {
			User user = dao.search(userId);
			System.out.println(user);
			return user;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see com.beer.model.service.UserService#searchAll()
	 */
	@Override
	public List<User> searchAll() {
		try {
			List<User> users = dao.searchAll();
			for (User user : users) {
				System.out.println(user);
			}
			return users;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see com.beer.model.service.UserService#insert(com.beer.model.dto.User)
	 */
	@Override
	public void insert(User user) {
		try {
			dao.insert(user);
			System.out.println("insert success");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/* (non-Javadoc)
	 * @see com.beer.model.service.UserService#update(com.beer.model.dto.User)
	 */
	@Override
	public void update(User user) {
		try {
			dao.update(user);
			System.out.println("update success");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Override
	public void delete(String userId) {
		try {
			dao.delete(userId);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
