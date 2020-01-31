package com.beer.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beer.model.dao.SNSDAO;
import com.beer.model.dto.SNS;

@Service
public class SNSServiceImp implements SNSService {
	
	@Autowired
	private SNSDAO snsdao;
	
	@Override
	public List<SNS> allsns() {
		try {
			List<SNS> articles = snsdao.allsns();
			
			return articles;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public SNS search(int articleId) {
		try {
			SNS article = snsdao.search(articleId);
			
			return article;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	};

	@Override
	public List<SNS> searchByUser(String userId){
		try {
			List<SNS> articles = snsdao.searchByUser(userId);
			
			return articles;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	};
	
	@Override
	public List<SNS> searchByEvery(String keyword){
		try {
			List<SNS> articles = snsdao.searchByEvery(keyword);
			
			return articles;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	};
	
	@Override
	public void insert(SNS sns) {
		try {
			snsdao.insert(sns);
		} catch (Exception e) {
			e.printStackTrace();
		}
	};
	
	@Override
	public void update(SNS sns) {
		try {
			snsdao.update(sns);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}; 
	
	@Override
	public void delete(int articleId) {
		try {
			snsdao.delete(articleId);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}; 
}
