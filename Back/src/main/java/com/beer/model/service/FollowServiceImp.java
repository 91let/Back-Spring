package com.beer.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beer.model.dao.FollowDAO;
import com.beer.model.dto.Follow;

@Service
public class FollowServiceImp implements FollowService {
	@Autowired
	private FollowDAO followdao;
	
	@Override
	public int countfollower(String followerId) {
		try {
			int count = followdao.countfollower(followerId);
			System.out.println(followerId + " 회원이 팔로워 한 수: " + count);
			
			return count;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	};
	
	@Override
	public List<String> searchfollower(String followingId) {
		try {
			List<String> list = followdao.searchfollower(followingId);
			System.out.print(followingId + " 회원이 팔로우 한 회원 리스트: ");
			for(String name:list)
				System.out.print(name + " ");
			System.out.println();

			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	};
	
	@Override
	public List<String> searchfollowing(String followerId) {
		try {
			List<String> list = followdao.searchfollowing(followerId);
			System.out.print(followerId + " 회원을 팔로우 한 회원의 리스트: ");
			for(String name:list)
				System.out.print(name + " ");
			System.out.println();
			
			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public int countfollowing(String followingId) {
		try {
			int count = followdao.countfollowing(followingId);
			System.out.println(followingId + " 회원을 팔로워 한 수: " + count);
			
			return count;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	};
	
	@Override
	public boolean insertfollow(Follow follow) {
		try {
			followdao.insertfollow(follow);
			System.out.println(follow.getFollowerId() + " 회원이 " + follow.getFollowingId() + " 회원을 팔로우");
			
			return true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	};
	
	@Override
	public boolean deletefollow(Follow follow) {
		try {
			followdao.deletefollow(follow);
			System.out.println(follow.getFollowerId() + " 회원이 " + follow.getFollowingId() + " 회원을 팔로우 취소");

			return true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	};
	
	@Override
	public int checkfollow(HashMap<String, String> map) {
		try {
			int check = followdao.checkfollow(map);
			System.out.println("check: " + check);

			if(check == 1) {
				System.out.println("팔로우 체크 여부: O");
				return check;
			}else {
				System.out.println("팔로우 체크 여부: X");
				return check;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

}