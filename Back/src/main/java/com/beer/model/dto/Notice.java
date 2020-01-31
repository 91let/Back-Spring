package com.beer.model.dto;

public class Notice {
	private int noticeId;
	private String userId;
	private String notice;
	private String link;
	
	public Notice() {}

	public int getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "Notice [noticeId=" + noticeId + ", userId=" + userId + ", notice=" + notice + ", link=" + link + "]";
	}
	
	
}
