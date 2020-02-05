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
	
	@GetMapping("/reply")
	@ApiOperation("all reply")
	public ResponseEntity<Map<String, Object>> searchAll() {
		return handleSuccess(replyService.searchAll());
	}
	
	@GetMapping("/reply/count")
	@ApiOperation("모든 reply 개수")
	public ResponseEntity<Map<String, Object>> countAll() {
		return handleSuccess(replyService.countAll());
	}

	@GetMapping("/reply/article/{articleId}")
	@ApiOperation("article 당 댓글 조회")
	public ResponseEntity<Map<String, Object>> searchByArticle(@PathVariable int articleId){
		return handleSuccess(replyService.searchByArticle(articleId));
	}
	
	@GetMapping("/reply/countarticle/{articleId}")
	@ApiOperation("article 당 댓글 개수")
	public ResponseEntity<Map<String, Object>> countByArticle(@PathVariable int articleId){
		return handleSuccess(replyService.countByArticle(articleId));
	}
	
	@GetMapping("/reply/user/{userId}")
	@ApiOperation("유저의 모든 댓글")
	public ResponseEntity<Map<String, Object>> searchByUser(@PathVariable String userId){
		return handleSuccess(replyService.searchByUser(userId));
	}
	
	@GetMapping("/reply/countuser/{userId}")
	@ApiOperation("유저의 댓글 개수")
	public ResponseEntity<Map<String, Object>> countByUser(@PathVariable String userId) {
		return handleSuccess(replyService.countByUser(userId));
	}
	
	@GetMapping("/reply/one/{articleId}/{userId}")
	@ApiOperation("한 aritlce에서 해당 유저의 댓글")
	public ResponseEntity<Map<String, Object>> searchOne(@PathVariable int articleId, @PathVariable String userId){
		return handleSuccess(replyService.searchOne(articleId, userId));
	}
	
	@GetMapping("/reply/countone/{articleId}/{userId}")
	@ApiOperation("한 aritlce에서 해당 유저의 댓글 개수 검색")
	public ResponseEntity<Map<String, Object>> countOne(@PathVariable int articleId, @PathVariable String userId) {
		return handleSuccess(replyService.countOne(articleId, userId));
	}

	@PostMapping("/reply")
	@ApiOperation("reply 정보 등록")
	public ResponseEntity<Map<String, Object>> insertReply(@RequestBody Reply reply){
		boolean result = replyService.insert(reply);

		if(result) return handleSuccess("등록 완료");
		else return handleFail("등록 실패", HttpStatus.UNAUTHORIZED);
	}

	@PutMapping("/reply")
	@ApiOperation("reply 정보 수정")
	public ResponseEntity<Map<String, Object>> updateReply(@RequestBody Reply reply){
		boolean result = replyService.update(reply);

		if(result) return handleSuccess("수정 완료");
		else return handleFail("등록 실패", HttpStatus.UNAUTHORIZED);
	}
	
	@DeleteMapping("/reply")
	@ApiOperation("reply 정보 삭제")
	public ResponseEntity<Map<String, Object>> deleteReply(@RequestBody Reply reply){
		boolean result = replyService.delete(reply);

		if(result) return handleSuccess("삭제 완료");
		else return handleFail("삭제 실패", HttpStatus.UNAUTHORIZED);
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
