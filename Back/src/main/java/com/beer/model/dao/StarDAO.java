package com.beer.model.dao;


import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.beer.model.dto.Star;

@Mapper
public interface StarDAO {
	public List<Star> searchall();
	public Star search(HashMap<String, String> map);
	public List<Star> searchByUser(String userId);
	public int countByUser(String userId);
	public int countByBeer(int beerId);
	public boolean insert(Star star);
	public boolean update(Star star);
	public double AVGScore(int beerId);
	public boolean deletestar(Star star);
	public List<Star> searchByBeer(int beerId);
	public List<Star> samestar(HashMap<String, String> map);
	public int countsamestar(HashMap<String, String> map);
}
