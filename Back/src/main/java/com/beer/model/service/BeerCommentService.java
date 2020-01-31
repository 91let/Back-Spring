package com.beer.model.service;

import java.util.List;

import com.beer.model.dto.BeerComment;

public interface BeerCommentService {
	public List<BeerComment> search();
	public void insert(BeerComment beerComment);
	public void update(BeerComment beerComment);
	public void delete(BeerComment beerComment);
}
