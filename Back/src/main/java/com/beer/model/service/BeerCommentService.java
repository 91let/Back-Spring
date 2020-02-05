package com.beer.model.service;

import java.util.List;

import com.beer.model.dto.BeerComment;

public interface BeerCommentService {
	public List<BeerComment> searchAll();
	public boolean insert(BeerComment beerComment);
	public boolean update(BeerComment beerComment);
	public boolean delete(int commentId);
	public int count(int beerId);
}