package com.beer.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.beer.model.dto.Beer;

@Mapper
public interface BeerDAO {
	// 맥주 클릭
	public Beer search(int beerId);
	
	// 맥주 이름으로 검색
	public List<Beer> searchByName(String beerName);

	// 제조업체로 검색
	public List<Beer> searchByBrewer(String brewer);
	
	// 원산지 검색
	public List<Beer> searchByNation(String nation);
	
	// 도수 검색
	public List<Beer> searchByAlcohol(String alcohol);
	
	// 맥주 종류로 검색
	public List<Beer> searchByCategory(String category);
	
	// 모든 맥주 리스트 검색
	public List<Beer> searchAll();
	
	public void insert(Beer beer);
	public void update(Beer beer);
	public void delete(int beerId);
}