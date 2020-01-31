package com.beer.model.dto;

public class Star {
	private String userId;
	private int beerId;
	private double score;
	
	public Star() {}

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

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Star [userId=" + userId + ", beerId=" + beerId + ", score=" + score + "]";
	}
	
}
