package com.beer.model.dto;

// 댓글 번호 (기본키)
// 유저 아이디
// 맥주 번호
// 날짜
// 내용

public class BeerComment {
	private int commentId;
	private String userId;
	private int beerId;
	private String date;
	private String contents;
	
	public BeerComment() {}

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
	
	public int getBeerId() {
		return beerId;
	}
	
	public void setBeerId(int beerId) {
		this.beerId = beerId;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getContents() {
		return contents;
	}
	
	public void setContents(String contents) {
		this.contents = contents;
	}

	@Override
	public String toString() {
		return "BeerComment [commentId=" + commentId + ", userId=" + userId + ", beerId=" + beerId + ", date=" + date
				+ ", contents=" + contents + "]";
	}
}