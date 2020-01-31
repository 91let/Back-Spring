package com.beer.model.service;

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
	public int search(Star star) {
		try {
			int stars = stardao.search(star);
			
			return stars;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
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
	public void insert(Star star) {
		try {
			stardao.insert(star);
		} catch (Exception e) {
			e.printStackTrace();
		}
	};
	
	@Override
	public void update(Star star) {
		try {
			stardao.update(star);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	public void deletestar(Star star) {
		try {
			stardao.deletestar(star);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	public List<Star> samestar(Star star){
		try {
			List<Star> stars = stardao.samestar(star);
			
			return stars;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	};
	
	@Override
	public int countsamestar(Star star) {
		try {
			int count = stardao.countsamestar(star);
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
