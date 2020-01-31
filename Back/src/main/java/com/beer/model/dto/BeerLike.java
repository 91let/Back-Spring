package com.beer.model.dto;

public class BeerLike {
	private String userId;
	private int beerId;
	
	public BeerLike() {}

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

	@Override
	public String toString() {
		return "BeerLike [userId=" + userId + ", beerId=" + beerId + "]";
	}
	
}
