package com.beer.model.service;

import java.util.List;

import com.beer.model.dto.Star;

public interface StarService {
	public List<Star> searchall();
	public int search(Star star);
	public List<Star> searchByUser(String userId);
	public int countByUser(String userId);
	public int countByBeer(int beerId);
	public void insert(Star star);
	public void update(Star star);
	public double AVGScore(int beerId);
	public void deletestar(Star star);
	public List<Star> searchByBeer(int beerId);
	public List<Star> samestar(Star star);
	public int countsamestar(Star star);
}
