package com.beer.model.service;

import java.util.List;

import com.beer.model.dto.SNSLike;

public interface SNSLikeService {
	public int search(String userId, int articleId);
	public boolean insert(SNSLike snsLike);
	public boolean delete(SNSLike snsLike);
	public int countLike(int articleId);
	public List<SNSLike> likeduser(int articleId);
	public List<SNSLike> likedarticle(String userId);
	public int countlikedarticlebyuser(String userId);
}
