package com.beer.model.service;


import java.util.List;

import com.beer.model.dto.Reply;

public interface ReplyService {
	public List<Reply> searchAll();
	public int countAll();
	public List<Reply> searchByArticle(int articleId);
	public int countByArticle(int articleId);
	public List<Reply> searchByUser(String userId);
	public int countByUser(String userId);
	public List<Reply> searchOne(int articleId, String userId);
	public int countOne(int articleId, String userId);
	public boolean insert(Reply reply);
	public boolean update(Reply reply);
	public boolean delete(Reply reply);
}
