package com.beer.model.service;

import com.beer.model.dto.BeerLike;

public interface BeerLikeService {
	// 이 사람이 찜했는지 안했는지 했으면 1 안했으면 0
	public int search(BeerLike beerLike);
	public void insert(BeerLike beerLike);
	public void delete(BeerLike beerLike);
	
	// 맥주가 찜받은 개수 세는 거
	public int countLike();
}