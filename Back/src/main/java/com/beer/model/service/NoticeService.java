package com.beer.model.service;

import java.util.List;

import com.beer.model.dto.Notice;

public interface NoticeService {
	public boolean insertnotice(Notice notice);
	public boolean deletenotice(int noticeId);	
	public List<Notice> allnotice(String userId);
	public List<Notice> recent30(String userId);
}
