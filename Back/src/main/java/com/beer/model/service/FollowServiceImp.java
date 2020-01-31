package com.beer.model.service;

import com.beer.model.dao.FollowDAO;
import com.beer.model.dto.Follow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FollowServiceImp implements FollowService {
	
	@Autowired
	private FollowDAO followdao;
	
	@Override
	public int countfollower(int followerId) {
		try {
			int count = followdao.countfollower(followerId);
			
			return count;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	};
	
	@Override
	public int countfollowing(int followingId) {
		try {
			int count = followdao.countfollowing(followingId);
			
			return count;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	};
	
	@Override
	public void insertfollow(Follow follow) {
		try {
			followdao.insertfollow(follow);
		} catch(Exception e) {
			e.printStackTrace();
		}
	};
	
	@Override
	public void deletefollow(Follow follow) {
		try {
			followdao.deletefollow(follow);
		} catch(Exception e) {
			e.printStackTrace();
		}
	};
	
	@Override
	public int checkfollow(Follow follow) {
		try {
			int check = followdao.checkfollow(follow);
			
			return check;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	};
	
}
