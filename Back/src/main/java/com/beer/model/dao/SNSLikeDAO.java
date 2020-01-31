package com.beer.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.beer.model.dto.SNSLike;
@Mapper
public interface SNSLikeDAO {
	public int search(SNSLike snsLike);
	public void insert(SNSLike snsLike);
	public void delete(SNSLike snsLike);
	public int countLike(int articleId);
}
