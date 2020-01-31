package com.beer.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.beer.model.dto.Reply;
@Mapper
public interface ReplyDAO {
	public List<Reply> searchByArticle(int articleId);
	public void insert(Reply reply);
	public void update(Reply reply);
	public void delete(Reply reply);
}
