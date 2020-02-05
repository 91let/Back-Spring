package com.beer.model.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.beer.model.dto.SNSLike;
@Mapper
public interface SNSLikeDAO {
	public int search(HashMap<String, String> map);
	public boolean insert(SNSLike snsLike);
	public boolean delete(SNSLike snsLike);
	public int countLike(int articleId);
	public List<SNSLike> likeduser(int articleId);
	public List<SNSLike> likedarticle(String userId);
	public int countlikedarticlebyuser(String userId);
}
