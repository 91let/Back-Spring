package com.beer.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.beer.model.dto.BeerLike;

@Mapper
public interface BeerLikeDAO {
	public int search(BeerLike beerLike);
	public void insert(BeerLike beerLike);
	public void delete(BeerLike beerLike);
	public int countLike();
}