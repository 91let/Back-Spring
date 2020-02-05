package com.beer.model.service;

import java.util.List;

import com.beer.model.dto.Star;

public interface StarService {
	public List<Star> searchall();
	public double search(int beerId, String userId);
	public List<Star> searchByUser(String userId);
	public int countByUser(String userId);
	public int countByBeer(int beerId);
	public boolean insert(Star star);
	public boolean update(Star star);
	public double AVGScore(int beerId);
	public boolean deletestar(Star star);
	public List<Star> searchByBeer(int beerId);
	public List<Star> samestar(int beerId, double score);
	public int countsamestar(int beerId, double score);
}
