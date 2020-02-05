package com.beer.model.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.beer.model.dto.Reply;
@Mapper
public interface ReplyDAO {
	public List<Reply> searchAll();
	public int countAll();
	public List<Reply> searchByArticle(int articleId);
	public int countByArticle(int articleId);
	public List<Reply> searchByUser(String userId);
	public int countByUser(String userId);
	public List<Reply> searchOne(HashMap<String, String> map);
	public int countOne(HashMap<String, String> map);
	public boolean insert(Reply reply);
	public boolean update(Reply reply);
	public boolean delete(Reply reply);
}
