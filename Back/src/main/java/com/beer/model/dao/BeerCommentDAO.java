package com.beer.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.beer.model.dto.BeerComment;

// 맥주게시글 번호
// 유저 아이디
// 맥주 아이디
// 날짜
// 내용

@Mapper
public interface BeerCommentDAO {
	public List<BeerComment> searchAll();
	public boolean insert(BeerComment beerComment);
	public boolean update(BeerComment beerComment);
	public boolean delete(int commentId);
	public int count(int beerId);
}