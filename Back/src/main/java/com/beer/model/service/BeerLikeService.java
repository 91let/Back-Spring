package com.beer.model.service;

import java.util.HashMap;

import com.beer.model.dto.BeerLike;

public interface BeerLikeService {
	public int search(HashMap<String, String> map);
	public boolean insert(BeerLike beerLike);
	public boolean delete(BeerLike beerLike);
	
	// 맥주가 찜받은 개수 세는 거
	public int countLike(int beerId);
}