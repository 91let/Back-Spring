package com.beer.model.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.beer.model.dto.CommentLike;

@Mapper
public interface CommentLikeDAO {
	public boolean insertCommentLike(CommentLike commentLike);
	public boolean deleteCommentLike(CommentLike commentLike);
	public int likeCommentLike(HashMap<String, String> map);
	public int countCommentLike(int commentId);
}