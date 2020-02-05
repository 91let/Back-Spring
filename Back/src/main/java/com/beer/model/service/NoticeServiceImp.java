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
	public boolean insertnotice(Notice notice) {
		try {
			noticedao.insertnotice(notice);
			
			return true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	};

	@Override
	public boolean deletenotice(int noticeId) {
		try {
			noticedao.deletenotice(noticeId);
		
			return true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	};	

	@Override
	public List<Notice> allnotice(String userId){
		try {
			List<Notice> notices = noticedao.allnotice(userId);
			
			for(Notice notice:notices)
				System.out.print(notice + " ");
			
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
			
			for(Notice notice:recentnotice)
				System.out.print(notice + " ");
			
			return recentnotice;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	};
}