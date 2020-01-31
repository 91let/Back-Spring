package com.beer.model.dto;

public class CommentLike {
	private int commentId;
	private String userId;
	
	public CommentLike() {}
	
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "CommentLike [commentId=" + commentId + ", userId=" + userId + "]";
	}
	
}
