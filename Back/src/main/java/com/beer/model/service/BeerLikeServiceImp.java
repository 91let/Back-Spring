package com.beer.model.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beer.model.dao.BeerLikeDAO;
import com.beer.model.dto.BeerLike;

@Service
public class BeerLikeServiceImp implements BeerLikeService{
	@Autowired
	BeerLikeDAO dao;

	@Override
	public int search(HashMap<String, String> map) {
		try {
			int result = dao.search(map);
			if(result == 1) {
				System.out.println("맥주 찜 여부: O");
				return result;
			}else {
				System.out.println("맥주 찜 여부: X");
				return result;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

		return -1;
	}

	@Override
	public boolean insert(BeerLike beerLike) {
		try {
			dao.insert(beerLike);
			System.out.println(beerLike.getUserId() + " 회원 " + beerLike.getBeerId() + "번 맥주 찜");
		
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean delete(BeerLike beerLike) {
		try {
			dao.delete(beerLike);
			System.out.println(beerLike.getBeerId() + "맥주 찜 삭제");
			
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}

	@Override 
	public int countLike(int beerId) {
		try {
			int result = dao.countLike(beerId);
			System.out.println("해당 맥주 찜 개수: " + result);
			
			return result;
		} catch(Exception e) { 
			e.printStackTrace(); 
		}

		return -1; 
	}
}