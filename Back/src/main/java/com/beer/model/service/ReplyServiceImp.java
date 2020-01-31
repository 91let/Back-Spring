package com.beer.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beer.model.dao.ReplyDAO;
import com.beer.model.dto.Reply;

@Service
public class ReplyServiceImp implements ReplyService {
	
	@Autowired
	private ReplyDAO replydao;
	
	@Override
	public List<Reply> searchByArticle(int articleId){
		try {
			List<Reply> replys = replydao.searchByArticle(articleId);
			
			return replys;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	};
	
	@Override
	public void insert(Reply reply) {
		try {
			replydao.insert(reply);
		} catch(Exception e) {
			e.printStackTrace();
		}
	};
	
	@Override
	public void update(Reply reply) {
		try {
			replydao.update(reply);
		} catch(Exception e) {
			e.printStackTrace();
		}
	};
	
	@Override
	public void delete(Reply reply) {
		try {
			replydao.delete(reply);
		} catch(Exception e) {
			e.printStackTrace();
		}
	};
}
