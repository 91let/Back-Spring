package com.beer.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beer.model.dao.CommentLikeDAO;
import com.beer.model.dto.CommentLike;

@Service
public class CommentLikeServiceImp implements CommentLikeService {
	@Autowired
	private CommentLikeDAO commentlikedao;
	
	@Override
	public int countlike(int commentId) {
		try {
			int count = commentlikedao.countlike(commentId);
			
			return count;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	};
	
	@Override
	public void insertcommentlike(CommentLike commentlike) {
		try {
			commentlikedao.insertcommentlike(commentlike);
		} catch(Exception e) {
			e.printStackTrace();
		}
	};

	@Override
	public void deletecommentlike(CommentLike commentlike) {
		try {
			commentlikedao.deletecommentlike(commentlike);
		} catch(Exception e) {
			e.printStackTrace();
		}
	};

//	유저가 있으면 1, 없으면 0
	@Override
	public int likecomment(CommentLike commentlike) {
		try {
			int check = commentlikedao.likecomment(commentlike);
			
			return check;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	};
}
