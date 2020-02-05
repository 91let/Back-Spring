package com.beer.model.service;

import java.util.HashMap;
import java.util.List;

import com.beer.model.dto.Follow;

public interface FollowService {
	public int countfollower(String followerId);
	public List<String> searchfollower(String followerId);
	public List<String> searchfollowing(String followingId);
	public int countfollowing(String followingId);
	public boolean insertfollow(Follow follow);
	public boolean deletefollow(Follow follow);
	public int checkfollow(HashMap<String, String> map);
}