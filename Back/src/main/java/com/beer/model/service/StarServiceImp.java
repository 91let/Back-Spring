package com.beer.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beer.model.dao.StarDAO;
import com.beer.model.dto.Star;

@Service
public class StarServiceImp implements StarService{
	
	@Autowired
	private StarDAO stardao;
	
	@Override
	public List<Star> searchall() {
		try {
			List<Star> stars = stardao.searchall();
			
			return stars;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public double search(int beerId, String userId) {
		
		double count = 11.0;
		
		try {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("beerId", Integer.toString(beerId));
			map.put("userId", userId);
			
			if (stardao.search(map) != null) {
				count = stardao.search(map).getScore();
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;
	};
	
	@Override
	public List<Star> searchByUser(String userId) {
		try {
			List<Star> stars = stardao.searchByUser(userId);
			
			return stars;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int countByUser(String userId) {
		try {
			int count = stardao.countByUser(userId);
			
			return count;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public int countByBeer(int beerId) {
		try {
			int count = stardao.countByBeer(beerId);
			
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public boolean insert(Star star) {
		try {
			stardao.insert(star);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	};
	
	@Override
	public boolean update(Star star) {
		try {
			stardao.update(star);
		
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	};
	
	@Override
	public double AVGScore(int beerId) {
		try {
			double score = stardao.AVGScore(beerId);
			
			return score;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0.0;
	};
	
	@Override
	public boolean deletestar(Star star) {
		try {
			stardao.deletestar(star);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	@Override
	public List<Star> searchByBeer(int beerId){
		try {
			List<Star> stars = stardao.searchByBeer(beerId);
			
			return stars;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	};
	
	@Override
	public List<Star> samestar(int beerId, double score){
		try {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("beerId", Integer.toString(beerId));
			map.put("score", Double.toString(score));
			List<Star> stars = stardao.samestar(map);
			
			return stars;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	};
	
	@Override
	public int countsamestar(int beerId, double score) {
		try {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("beerId", Integer.toString(beerId));
			map.put("score", Double.toString(score));
			int count = stardao.countsamestar(map);
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
