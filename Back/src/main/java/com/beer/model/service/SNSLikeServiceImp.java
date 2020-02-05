package com.beer.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beer.model.dao.SNSLikeDAO;
import com.beer.model.dto.SNSLike;

@Service
public class SNSLikeServiceImp implements SNSLikeService {
	
	@Autowired
	private SNSLikeDAO snslikedao;
	
	@Override
	public int search(String userId, int articleId) {
		try {
			
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("userId", userId);
			map.put("articleId", Integer.toString(articleId));
			
			int check = snslikedao.search(map);
			
			return check;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	};
	
	@Override
	public boolean insert(SNSLike snsLike) {
		try {
			snslikedao.insert(snsLike);
			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	};
	
	@Override
	public boolean delete(SNSLike snsLike) {
		try {
			snslikedao.delete(snsLike);
			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
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
	
	@Override
	public List<SNSLike> likeduser(int articleId){
		try {
			List<SNSLike> liked = snslikedao.likeduser(articleId);
			
			return liked;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	};
	
	@Override
	public List<SNSLike> likedarticle(String userId){
		try {
			List<SNSLike> liked = snslikedao.likedarticle(userId);
			
			return liked;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	};
	
	@Override
	public int countlikedarticlebyuser(String userId) {
		try {
			int count = snslikedao.countlikedarticlebyuser(userId);
			
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	};
}
