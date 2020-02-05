package com.beer.model.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.beer.model.dto.Follow;
@Mapper
public interface FollowDAO {
	public int countfollower(String followerId);
	public List<String> searchfollower(String followerId);
	public List<String> searchfollowing(String followingId);
	public int countfollowing(String followingId);
	public boolean insertfollow(Follow follow);
	public boolean deletefollow(Follow follow);
	public int checkfollow(HashMap<String, String> map);
}