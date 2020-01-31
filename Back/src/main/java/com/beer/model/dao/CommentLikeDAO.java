package com.beer.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.beer.model.dto.CommentLike;

@Mapper
public interface CommentLikeDAO {
	public int countlike(int commentId);
	public void insertcommentlike(CommentLike commentlike);
	public void deletecommentlike(CommentLike commentlike);
	public int likecomment(CommentLike commentlike);
}
