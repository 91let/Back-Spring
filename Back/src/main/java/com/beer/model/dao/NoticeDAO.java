package com.beer.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.beer.model.dto.Notice;
@Mapper
public interface NoticeDAO {
	public void insertnotice(Notice notice);
	public void deletenotice(int noticeId);	
	public List<Notice> allnotice(String userId);
	public List<Notice> recent30(String userId);
}
