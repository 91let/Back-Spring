package com.beer.model.service;

import java.util.HashMap;

import com.beer.model.dto.CommentLike;

public interface CommentLikeService {
	public boolean insertCommentLike(CommentLike commentLike);
	public boolean deleteCommentLike(CommentLike commentLike);
	public int likeCommentLike(HashMap<String, String> map);
	public int countCommentLike(int commentId);
}