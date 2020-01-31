package com.beer.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beer.model.dao.BeerLikeDAO;
import com.beer.model.dto.BeerLike;

@Service
public class BeerLikeServiceImp implements BeerLikeService{
	@Autowired
	BeerLikeDAO dao;

	@Override
	public int search(BeerLike beerLike) {
		int result = 0;

		try {
			result = dao.search(beerLike);
			System.out.println("맥주 찜 여부: " + result);
		}catch(Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public void insert(BeerLike beerLike) {
		try {
			dao.insert(beerLike);
			System.out.println("찜 성공");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(BeerLike beerLike) {
		try {
			dao.delete(beerLike);
			System.out.println("찜 삭제 성공");
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	@Override 
	public int countLike() {
		int result = 0;
		try {
			result =dao.countLike();
			System.out.println("해당 맥주 찜 개수: " + result);
		} catch(Exception e) { e.printStackTrace(); }

		return result; 
	}
}