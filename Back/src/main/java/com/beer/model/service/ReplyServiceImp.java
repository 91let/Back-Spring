package com.beer.model.service;

import java.util.HashMap;
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
	public List<Reply> searchAll(){
		try {
			List<Reply> replies = replydao.searchAll();
			
			return replies;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	};
	
	@Override
	public int countAll() {
		try {
			int count = replydao.countAll();
			
			return count;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
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
	public int countByArticle(int articleId) {
		try {
			int check = replydao.countByArticle(articleId);
			
			return check;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	};
	
	@Override
	public List<Reply> searchByUser(String userId){
		try {
			List<Reply> replies = replydao.searchByUser(userId);
			
			return replies;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	};
	
	@Override
	public int countByUser(String userId) {
		try {
			int count = replydao.countByUser(userId);
			
			return count;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public List<Reply> searchOne(int articleId, String userId) {
		try {
			HashMap<String, String> map = new HashMap<String, String>();
			
			map.put("articleId", Integer.toString(articleId));
			map.put("userId", userId);
			
			List<Reply> reply = replydao.searchOne(map);
			
			return reply;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	};
	
	@Override
	public int countOne(int articleId, String userId) {
		try {
			HashMap<String, String> map = new HashMap<String, String>();
			
			map.put("articleId", Integer.toString(articleId));
			map.put("userId", userId);
			
			int count = replydao.countOne(map);
			
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
		
	@Override
	public boolean insert(Reply reply) {
		try {
			replydao.insert(reply);
	
			return true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	};
	
	@Override
	public boolean update(Reply reply) {
		try {
			replydao.update(reply);
		
			return true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	};
	
	@Override
	public boolean delete(Reply reply) {
		try {
			replydao.delete(reply);
			
			return true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	};
}
