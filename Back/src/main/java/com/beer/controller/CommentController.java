package com.beer.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.beer.model.dto.CommentLike;
import com.beer.model.service.CommentLikeService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"*"}, maxAge=6000)
@RestController
public class CommentController {
	@Autowired
	private CommentLikeService commentLikeService;
	
	@ExceptionHandler 
	public ResponseEntity<Map<String, Object>> handler(Exception e){
		return handleFail(e.getMessage(), HttpStatus.OK);
	}
	
	@PostMapping("/beer/commentLikeInsert")
	@ApiOperation("게시글 좋아요")
	public ResponseEntity<Map<String, Object>> insertCommentLike(@RequestBody CommentLike commentLike){
		boolean result = commentLikeService.insertCommentLike(commentLike);
		if(result) return handleSuccess(commentLike.getUserId() + " 회원" + commentLike.getCommentId() + "번 게시글 좋아요 표시");
		else return handleFail("등록 실패", HttpStatus.UNAUTHORIZED);
				
	}
	
	@DeleteMapping("/beer/commentLikeDelete")
	@ApiOperation("게시글 좋아요 취소")
	public ResponseEntity<Map<String, Object>> deleteCommentLike(@RequestBody CommentLike commentLike){
		boolean result = commentLikeService.deleteCommentLike(commentLike);
		if(result) return handleSuccess(commentLike.getUserId() + " 회원" + commentLike.getCommentId() + "번 게시글 좋아요 취소");
		else return handleFail("등록 실패", HttpStatus.UNAUTHORIZED);
	}
	
	@GetMapping("/beer/commentLike/{userId}/{commentId}")
	@ApiOperation("특정 회원 게시글 좋아요 여부 1: O, 0: X")
	public ResponseEntity<Map<String, Object>> likeCommentLike(@PathVariable String userId, int commentId){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("commentId", Integer.toString(commentId));
		
		int result = commentLikeService.likeCommentLike(map);
		return handleSuccess(userId + " 회원" + commentId + "번 게시글 좋아요 여부: " + result + '\n');
	}
	
	@GetMapping("/beer/countCommentLike/{commentId}")
	@ApiOperation("해당 게시글 좋아요 개수")
	public ResponseEntity<Map<String, Object>> countCommentLike(@PathVariable int commentId){
		commentLikeService.countCommentLike(commentId);
		return handleSuccess(commentId + "번 게시글 좋아요 개수: " + commentId);
	}
	
	public ResponseEntity<Map<String, Object>> handleSuccess(Object data){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("state", "ok");
		resultMap.put("data", data);
		return new ResponseEntity<Map<String,Object>>(resultMap, HttpStatus.OK);
	}

	public ResponseEntity<Map<String, Object>> handleFail(Object data, HttpStatus status){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("state", "fail");
		resultMap.put("data", data);
		return new ResponseEntity<Map<String,Object>>(resultMap, status);
	}
}