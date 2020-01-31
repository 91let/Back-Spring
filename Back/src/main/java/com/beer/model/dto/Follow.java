package com.beer.model.dto;

public class Follow {
	private String followerId;
	private String followingId;
	
	public Follow() {}

	public String getFollowerId() {
		return followerId;
	}

	public void setFollowerId(String followerId) {
		this.followerId = followerId;
	}

	public String getFollowingId() {
		return followingId;
	}

	public void setFollowingId(String followingId) {
		this.followingId = followingId;
	}

	@Override
	public String toString() {
		return "Follow [followerId=" + followerId + ", followingId=" + followingId + "]";
	}
	
}
