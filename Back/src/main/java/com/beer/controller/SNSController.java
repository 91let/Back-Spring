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

import com.beer.model.dto.SNS;
import com.beer.model.dto.SNSLike;
import com.beer.model.service.SNSLikeService;
import com.beer.model.service.SNSService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"*"}, maxAge=6000)
@RestController
public class SNSController {
	
	@Autowired
	private SNSService snsService;
	
	@Autowired
	private SNSLikeService snslikeService;
	
	@ExceptionHandler 
	public ResponseEntity<Map<String, Object>> handler(Exception e){
		return handleFail(e.getMessage(), HttpStatus.OK);
	}
	
	@GetMapping("/sns")
	@ApiOperation("모든 sns 조회")
	public ResponseEntity<Map<String, Object>> allArticle() {
		return handleSuccess(snsService.allsns());
	}
	
	@GetMapping("/sns/article/{articleId}")
	@ApiOperation("한 개의 sns 조회")
	public ResponseEntity<Map<String, Object>> oneArticle(@PathVariable int articleId){
		return handleSuccess(snsService.search(articleId));
	}
	
	@GetMapping("/sns/user/{userId}")
	@ApiOperation("user 당 sns 조회")
	public ResponseEntity<Map<String, Object>> articleByUser(@PathVariable String userId){
		return handleSuccess(snsService.searchByUser(userId));
	}
	
	@GetMapping("/sns/keyword/{keyword}")
	@ApiOperation("keyword 로 sns 조회")
	public ResponseEntity<Map<String, Object>> articleByKeword(@PathVariable String keyword){
		return handleSuccess(snsService.searchByEvery(keyword));
	}

	@PostMapping("/sns")
	@ApiOperation("sns 등록")
	public ResponseEntity<Map<String, Object>> insertSNS(@RequestBody SNS sns){
		snsService.insert(sns);
		return handleSuccess("등록 완료");
	}

	@PutMapping("/sns")
	@ApiOperation("sns 수정")
	public ResponseEntity<Map<String, Object>> updateSNS(@RequestBody SNS sns){
		snsService.update(sns);
		return handleSuccess("수정 완료");
	}
	
	@DeleteMapping("/sns/{articleId}")
	@ApiOperation("sns 삭제")
	public ResponseEntity<Map<String, Object>> deleteSNS(@PathVariable int articleId){
		snsService.delete(articleId);
		return handleSuccess("삭제 완료");
	}
	
	@GetMapping("/snslike")
	@ApiOperation("sns like 여부 판별")
	public ResponseEntity<Map<String, Object>> searchLike(@RequestBody SNSLike snsLike) {
		return handleSuccess(snslikeService.search(snsLike));
	}
	
	@PostMapping("/snslike")
	@ApiOperation("like")
	public ResponseEntity<Map<String, Object>> insertLike(@RequestBody SNSLike snsLike) {
		snslikeService.insert(snsLike);
		return handleSuccess("등록 완료");
	}
	
	@DeleteMapping("/snslike")
	@ApiOperation("unlike")
	public ResponseEntity<Map<String, Object>> deleteLike(@RequestBody SNSLike snsLike) {
		snslikeService.delete(snsLike);
		return handleSuccess("삭제 완료");
	}
	
	@GetMapping("/snslike/{articleId}")
	@ApiOperation("like 개수")
	public ResponseEntity<Map<String, Object>> countLike(@PathVariable int articleId) {
		return handleSuccess(snslikeService.countLike(articleId));
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
