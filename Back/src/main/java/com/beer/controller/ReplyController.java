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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.beer.model.dto.Reply;
import com.beer.model.service.ReplyService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"*"}, maxAge=6000)
@RestController
public class ReplyController {
	
	@Autowired
	private ReplyService replyService;
	
	@ExceptionHandler 
	public ResponseEntity<Map<String, Object>> handler(Exception e){
		return handleFail(e.getMessage(), HttpStatus.OK);
	}

	@GetMapping("/reply/article/{articleId}")
	@ApiOperation("article 당 댓글 조회")
	public ResponseEntity<Map<String, Object>> searchByArticle(@PathVariable int articleId){
		return handleSuccess(replyService.searchByArticle(articleId));
	}

	@PostMapping("/reply")
	@ApiOperation("reply 정보 등록")
	public ResponseEntity<Map<String, Object>> insertReply(@RequestBody Reply reply){
		replyService.insert(reply);
		return handleSuccess("등록 완료");
	}

	@PutMapping("/reply")
	@ApiOperation("reply 정보 수정")
	public ResponseEntity<Map<String, Object>> updateReply(@RequestBody Reply reply){
		replyService.update(reply);
		return handleSuccess("수정 완료");
	}
	
	@DeleteMapping("/reply")
	@ApiOperation("reply 정보 삭제")
	public ResponseEntity<Map<String, Object>> deleteReply(@RequestBody Reply reply){
		replyService.delete(reply);
		return handleSuccess("삭제 완료");
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
