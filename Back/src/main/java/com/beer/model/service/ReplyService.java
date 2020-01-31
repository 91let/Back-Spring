package com.beer.model.service;

import java.util.List;

import com.beer.model.dto.Reply;

public interface ReplyService {
	public List<Reply> searchByArticle(int articleId);
	public void insert(Reply reply);
	public void update(Reply reply);
	public void delete(Reply reply);
}
