package com.beer.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.beer.model.dto.Follow;
@Mapper
public interface FollowDAO {
	public int countfollower(int followerId);
	public int countfollowing(int followingId);
	public void insertfollow(Follow follow);
	public void deletefollow(Follow follow);
	public int checkfollow(Follow follow);
}
