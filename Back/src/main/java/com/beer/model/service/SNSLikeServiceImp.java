package com.beer.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beer.model.dao.SNSLikeDAO;
import com.beer.model.dto.SNSLike;

@Service
public class SNSLikeServiceImp implements SNSLikeService {
	
	@Autowired
	private SNSLikeDAO snslikedao;
	
	@Override
	public int search(SNSLike snsLike) {
		try {
			int check = snslikedao.search(snsLike);
			
			return check;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	};
	
	@Override
	public void insert(SNSLike snsLike) {
		try {
			snslikedao.insert(snsLike);
		}catch(Exception e) {
			e.printStackTrace();
		}
	};
	
	@Override
	public void delete(SNSLike snsLike) {
		try {
			snslikedao.delete(snsLike);
		}catch(Exception e) {
			e.printStackTrace();
		}
	};
	
	@Override
	public int countLike(int articleId) {
		try {
			int count = snslikedao.countLike(articleId);
			
			return count;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	};
}
