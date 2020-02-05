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
	
	@GetMapping("/sns/count")
	@ApiOperation("모든 sns 개수")
	public ResponseEntity<Map<String, Object>> countallArticle() {
		return handleSuccess(snsService.countallsns());
	}
	
	@GetMapping("/sns/article/{articleId}")
	@ApiOperation("한 개의 sns 조회")
	public ResponseEntity<Map<String, Object>> oneArticle(@PathVariable int articleId){
		return handleSuccess(snsService.search(articleId));
	}
	
	@GetMapping("/sns/time")
	@ApiOperation("시간순 sns")
	public ResponseEntity<Map<String, Object>> articleByTime() {
		return handleSuccess(snsService.snsByTime());
	}
	
	@GetMapping("/sns/follow/{userId}")
	@ApiOperation("follower sns 조회")
	public ResponseEntity<Map<String, Object>> articleByFollow(@PathVariable String userId){
		return handleSuccess(snsService.searchByFollow(userId));
	}
	
	@GetMapping("/sns/countfollow/{userId}")
	@ApiOperation("follower sns 개수 조회")
	public ResponseEntity<Map<String, Object>> countArticleByFollow(@PathVariable String userId) {
		return handleSuccess(snsService.countByFollow(userId));
	}
	
	@GetMapping("/sns/nickname/{nickname}")
	@ApiOperation("nickname으로 sns 조회")
	public ResponseEntity<Map<String, Object>> articleByNickname(@PathVariable String nickname){
		return handleSuccess(snsService.searchByNickname(nickname));
	}
	
	@GetMapping("/sns/countnickname/{nickname}")
	@ApiOperation("nickname으로 sns 개수 조회")
	public ResponseEntity<Map<String, Object>> countArticleByNickname(@PathVariable String nickname) {
		return handleSuccess(snsService.countByNickname(nickname));
	}
	
	@GetMapping("/sns/contents/{contents}")
	@ApiOperation("내용으로 sns 조회")
	public ResponseEntity<Map<String, Object>> articleByContents(@PathVariable String contents){
		return handleSuccess(snsService.searchByContents(contents));
	}
	
	@GetMapping("/sns/countcontents/{contents}")
	@ApiOperation("내용으로 sns 개수 조회")
	public ResponseEntity<Map<String, Object>> countArticleByContents(@PathVariable String contents) {
		return handleSuccess(snsService.countByContents(contents));
	}

	@PostMapping("/sns")
	@ApiOperation("sns 등록")
	public ResponseEntity<Map<String, Object>> insertSNS(@RequestBody SNS sns){
		boolean result = snsService.insert(sns);

		if(result) return handleSuccess("등록 완료");
		else return handleFail("등록 실패", HttpStatus.UNAUTHORIZED);
	}

	@PutMapping("/sns")
	@ApiOperation("sns 수정")
	public ResponseEntity<Map<String, Object>> updateSNS(@RequestBody SNS sns){
		boolean result = snsService.update(sns);
		
		if(result) return handleSuccess("수정 완료");
		else return handleFail("수정 실패", HttpStatus.UNAUTHORIZED);
	}
	
	@DeleteMapping("/sns/{articleId}")
	@ApiOperation("sns 삭제")
	public ResponseEntity<Map<String, Object>> deleteSNS(@PathVariable int articleId){
		boolean result = snsService.delete(articleId);

		if(result) return handleSuccess("삭제 완료");
		else return handleFail("삭제 실패", HttpStatus.UNAUTHORIZED);
	}
	
	@GetMapping("/snslike/{userId}/{articleId}")
	@ApiOperation("sns like 여부 판별")
	public ResponseEntity<Map<String, Object>> searchLike(@PathVariable String userId, @PathVariable int articleId) {
		return handleSuccess(snslikeService.search(userId, articleId));
	}
	
	@PostMapping("/snslike")
	@ApiOperation("like")
	public ResponseEntity<Map<String, Object>> insertLike(@RequestBody SNSLike snsLike) {
		if(snslikeService.insert(snsLike)) return handleSuccess("등록 완료");
		else return handleFail("등록 실패", HttpStatus.UNAUTHORIZED);
	}
	
	@DeleteMapping("/snslike")
	@ApiOperation("unlike")
	public ResponseEntity<Map<String, Object>> deleteLike(@RequestBody SNSLike snsLike) {
		if(snslikeService.delete(snsLike)) return handleSuccess("삭제 완료");
		else return handleFail("삭제 실패", HttpStatus.UNAUTHORIZED);
	}
	
	@GetMapping("/snslike/countuser/{articleId}")
	@ApiOperation("like 개수")
	public ResponseEntity<Map<String, Object>> countLike(@PathVariable int articleId) {
		return handleSuccess(snslikeService.countLike(articleId));
	}
	
	@GetMapping("/snslike/userlist/{articleId}")
	@ApiOperation("sns 게시글 좋아하는 유저 리스트")
	public ResponseEntity<Map<String, Object>> searchLikeUser(@PathVariable int articleId){
		return handleSuccess(snslikeService.likeduser(articleId));
	}
	
	@GetMapping("/snslike/countarticle/{userId}")
	@ApiOperation("유저당 좋아하는 sns 개수")
	public ResponseEntity<Map<String, Object>> countLikeArticle(@PathVariable String userId) {
		return handleSuccess(snslikeService.countlikedarticlebyuser(userId));
	}
	
	@GetMapping("/snslike/articlelist/{userId}")
	@ApiOperation("유저당 좋아하는 sns 리스트")
	public ResponseEntity<Map<String, Object>> searchLikeArticle(@PathVariable String userId) {
		return handleSuccess(snslikeService.likedarticle(userId));
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
