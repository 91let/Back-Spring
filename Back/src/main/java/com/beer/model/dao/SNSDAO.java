package com.beer.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.beer.model.dto.SNS;
@Mapper
public interface SNSDAO {
	public List<SNS> allsns();
	public SNS search(int articleId);
	public List<SNS> searchByUser(String userId); 
	public List<SNS> searchByEvery(String keyword); 
	public void insert(SNS sns);
	public void update(SNS sns); 
	public void delete(int articleId); 
}