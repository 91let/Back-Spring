package com.beer.model.service;

import com.beer.model.dto.CommentLike;

public interface CommentLikeService {
	public int countlike(int commentId);
	public void insertcommentlike(CommentLike commentlike);
	public void deletecommentlike(CommentLike commentlike);
	public int likecomment(CommentLike commentlike);
}
