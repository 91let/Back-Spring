package com.beer.model.dto;

public class User {
	private String userId;
	private String password;
	private String nickname;
	private String profile;
	private String intro;
	private int master;
	
	User(){}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public int getMaster() {
		return master;
	}

	public void setMaster(int master) {
		this.master = master;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", nickname=" + nickname + ", profile="
				+ (profile != null) + ", intro=" + intro + ", master=" + master + "]";
	};
}