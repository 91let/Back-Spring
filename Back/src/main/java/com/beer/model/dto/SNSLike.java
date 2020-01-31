package com.beer.model.dto;

public class SNSLike {
	private String userId;
	private int articleId;
	
	public SNSLike() {}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	@Override
	public String toString() {
		return "SNSLike [userId=" + userId + ", articleId=" + articleId + "]";
	}
	
}
