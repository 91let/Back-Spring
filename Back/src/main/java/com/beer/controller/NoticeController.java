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

import com.beer.model.dto.Notice;
import com.beer.model.service.NoticeService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"*"}, maxAge=6000)
@RestController
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	@ExceptionHandler 
	public ResponseEntity<Map<String, Object>> handler(Exception e){
		return handleFail(e.getMessage(), HttpStatus.OK);
	}
	
	@PostMapping("/noticeWrite")
	@ApiOperation("알림 생성하기")
	public ResponseEntity<Map<String, Object>> insertnotice(@RequestBody Notice notice){
		boolean result = noticeService.insertnotice(notice);
		if(result) return handleSuccess(notice.getUserId() + " 회원" + notice.getNotice() + " 알림 작성 " + ", 알림 링크: " + notice.getLink());
		else return handleFail("등록 실패", HttpStatus.UNAUTHORIZED);
	}
	
	@DeleteMapping("/noticeDelete/{noticeId}")
	@ApiOperation("알림 생성하기")
	public ResponseEntity<Map<String, Object>> deletenotice(@PathVariable int noticeId){
		boolean result = noticeService.deletenotice(noticeId);

		if(result) return handleSuccess(noticeId + "번 알림 삭제");
		else return handleFail("삭제 실패", HttpStatus.UNAUTHORIZED);
	}
	
	@GetMapping("/noticeList/{userId}")
	@ApiOperation("해당 회원의 모든 알림 목록")
	public ResponseEntity<Map<String, Object>> allnotice(@PathVariable String userId){
		return handleSuccess(noticeService.allnotice(userId));
	}

	@GetMapping("/noticeList30/{userId}")
	@ApiOperation("해당 회원의 30개의 최근 알림 목록")
	public ResponseEntity<Map<String, Object>> recent30(@PathVariable String userId){
		return handleSuccess(noticeService.recent30(userId));
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