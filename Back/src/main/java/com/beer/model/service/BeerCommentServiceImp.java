package com.beer.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beer.model.dao.BeerCommentDAO;
import com.beer.model.dto.BeerComment;

@Service
public class BeerCommentServiceImp implements BeerCommentService {
	@Autowired
	BeerCommentDAO dao;
	
	@Override
	public List<BeerComment> search() {
		try {
			List<BeerComment> list = dao.search();
			for(BeerComment bc:list) System.out.println(bc);
			
			return list;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void insert(BeerComment beerComment) {
		try {
			dao.insert(beerComment);
			
			System.out.println("맥주 댓글 저장 성공");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(BeerComment beerComment) {
		try {
			dao.update(beerComment);
			System.out.println("맥주 댓글 변경 성공");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(BeerComment beerComment) {
		try {
			dao.delete(beerComment);
			
			System.out.println("맥주 댓글 삭제 성공");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}	