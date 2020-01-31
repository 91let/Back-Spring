package com.beer.model.service;

import com.beer.model.dto.Follow;

public interface FollowService {
	public int countfollower(int followerId);
	public int countfollowing(int followingId);
	public void insertfollow(Follow follow);
	public void deletefollow(Follow follow);
	public int checkfollow(Follow follow);
}
