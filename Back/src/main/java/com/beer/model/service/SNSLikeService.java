package com.beer.model.service;

import com.beer.model.dto.SNSLike;

public interface SNSLikeService {
	public int search(SNSLike snsLike);
	public void insert(SNSLike snsLike);
	public void delete(SNSLike snsLike);
	public int countLike(int articleId);
}
