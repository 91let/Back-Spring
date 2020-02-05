package com.beer.model.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.beer.model.dto.BeerLike;

@Mapper
public interface BeerLikeDAO {
	public int search(HashMap<String, String> map);
	public boolean insert(BeerLike beerLike);
	public boolean delete(BeerLike beerLike);
	public int countLike(int beerId);
}