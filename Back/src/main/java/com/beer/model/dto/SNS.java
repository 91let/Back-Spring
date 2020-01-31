package com.beer.model.dto;

public class SNS {
	private int articleId;
	private int userId;
	private String date;
	private byte[] picture;
	private String contents;
	
	SNS(){}

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	@Override
	public String toString() {
		return "SNS [articleId=" + articleId + ", userId=" + userId + ", date=" + date + ", picture="
				+ (picture != null) + ", contents=" + contents + "]";
	}
	
	
}
