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
	public List<BeerComment> searchAll() {
		try {
			List<BeerComment> list = dao.searchAll();
			for(BeerComment bc:list) System.out.println(bc);
			
			return list;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean insert(BeerComment beerComment) {
		try {
			dao.insert(beerComment);
			System.out.println("맥주 댓글 저장 성공");
			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean update(BeerComment beerComment) {
		try {
			dao.update(beerComment);
			System.out.println("맥주 댓글 변경 성공");
			
			return true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean delete(int commentId) {
		try {
			dao.delete(commentId);
			System.out.println("맥주 댓글 삭제 성공");
			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public int count(int beerId) {
		try {
			int result = dao.count(beerId);
			System.out.print("댓글 개수: " + result);
	
			return result;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
}	