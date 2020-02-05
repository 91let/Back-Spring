package com.beer.model.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beer.model.dao.CommentLikeDAO;
import com.beer.model.dto.CommentLike;

@Service
public class CommentLikeServiceImp implements CommentLikeService {
	@Autowired
	private CommentLikeDAO commentLikedao;
		
	@Override
	public boolean insertCommentLike(CommentLike commentLike) {
		try {
			commentLikedao.insertCommentLike(commentLike);
			
			return true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	};

	@Override
	public boolean deleteCommentLike(CommentLike commentLike) {
		try {
			commentLikedao.deleteCommentLike(commentLike);
			
			return true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	};

	// 유저가 있으면 1, 없으면 0
	@Override
	public int likeCommentLike(HashMap<String, String> map) {
		try {
			int result = commentLikedao.likeCommentLike(map);
			
			System.out.println("result: " + result);
			if(result == 1) {
				System.out.println("게시글 좋아요 여부: O");
				return result;
			}else {
				System.out.println("게시글 좋아요 여부: X");
				return result;
			}
		}catch(Exception e) {
				e.printStackTrace();
			}
		
		return 0;
	};
	
	@Override
	public int countCommentLike(int commentId) {
		try {
			int count = commentLikedao.countCommentLike(commentId);
			System.out.println("해당 게시글 좋아요 개수: " + count);

			return count;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	};
}