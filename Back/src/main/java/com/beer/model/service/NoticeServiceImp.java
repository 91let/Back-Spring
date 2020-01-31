package com.beer.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beer.model.dao.NoticeDAO;
import com.beer.model.dto.Notice;

@Service
public class NoticeServiceImp implements NoticeService{
	
	@Autowired
	private NoticeDAO noticedao;
	
	@Override
	public void insertnotice(Notice notice) {
		try {
			noticedao.insertnotice(notice);
		} catch(Exception e) {
			e.printStackTrace();
		}
	};

	@Override
	public void deletenotice(int noticeId) {
		try {
			noticedao.deletenotice(noticeId);
		} catch(Exception e) {
			e.printStackTrace();
		}
	};	

	@Override
	public List<Notice> allnotice(String userId){
		try {
			List<Notice> notices = noticedao.allnotice(userId);
			
			return notices;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	};
	
	@Override
	public List<Notice> recent30(String userId) {
		try {
			List<Notice> recentnotice = noticedao.recent30(userId);
			
			return recentnotice;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	};
}
