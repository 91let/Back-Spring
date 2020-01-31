package com.beer.model.service;

import java.util.List;

import com.beer.model.dto.SNS;

public interface SNSService {
	public List<SNS> allsns();
	public SNS search(int articleId);
	public List<SNS> searchByUser(String userId); 
	public List<SNS> searchByEvery(String keyword);
	public void insert(SNS sns);
	public void update(SNS sns); 
	public void delete(int articleId); 
}
