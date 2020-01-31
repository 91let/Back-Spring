package com.beer.model.dto;

public class Reply {
	private int articleId;
	private int userId;
	private String date;
	private String reply;
	
	Reply(){}

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

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	@Override
	public String toString() {
		return "Reply [articleId=" + articleId + ", userId=" + userId + ", date=" + date + ", reply=" + reply + "]";
	};
	
}
