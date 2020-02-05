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

import com.beer.model.dto.Follow;
import com.beer.model.service.FollowService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"*"}, maxAge=6000)
@RestController
public class FollowController {
	@Autowired
	private FollowService followService;

	@ExceptionHandler 
	public ResponseEntity<Map<String, Object>> handler(Exception e){
		return handleFail(e.getMessage(), HttpStatus.OK);
	}
	
	@GetMapping("/follow/myFollowCount/{followerId}")
	@ApiOperation("내가 팔로잉한 사람의 수")
	public ResponseEntity<Map<String, Object>> countMyFollow(@PathVariable String followerId){
		return handleSuccess(followService.countfollower(followerId));
	}

	// ---------------
	@GetMapping("follow/myFollowList/{followerId}")
	@ApiOperation("내가 팔로잉한 사람의 리스트")
	public ResponseEntity<Map<String, Object>> myFollow(@PathVariable String followerId){
		return handleSuccess(followService.searchfollower(followerId));
	}

	@GetMapping("follow/myFollowerList/{followingId}")
	@ApiOperation("나를 팔로우한 사람의 리스트")
	public ResponseEntity<Map<String, Object>> myFollower(@PathVariable String followingId){
		return handleSuccess(followService.searchfollowing(followingId));
	}
	// ---------------
	
	@GetMapping("/following/{followingId}")
	@ApiOperation("해당 회원을 팔로잉한 사람의 수")
	public ResponseEntity<Map<String, Object>> searchFollowing(@PathVariable String followingId){
		return handleSuccess(followService.countfollowing(followingId));
	}

	@PostMapping("/follow/insert")
	@ApiOperation("팔로잉 저장")
	public ResponseEntity<Map<String, Object>> insertFollow(@RequestBody Follow follow){
		boolean result = followService.insertfollow(follow);
		if(result) return handleSuccess(follow.getFollowerId() + " 회원이 " + follow.getFollowingId() + "회원을 팔로우하였습니다.");
		else return handleFail("등록 실패", HttpStatus.UNAUTHORIZED);
	}

	@DeleteMapping("/follow/delete")
	@ApiOperation("팔로잉 취소")
	public ResponseEntity<Map<String, Object>> deleteFollow(@RequestBody Follow follow){
		boolean result = followService.deletefollow(follow);
		if(result) return handleSuccess(follow.getFollowerId() + " 회원이 " + follow.getFollowingId() + " 회원 팔로우를 취소하였습니다.");
		else return handleFail("등록 실패", HttpStatus.UNAUTHORIZED);
	}

	@GetMapping("/follow/{followerId}/{followingId}")
	@ApiOperation("팔로잉 여부")
	public ResponseEntity<Map<String, Object>> checkFollowing(@PathVariable String followerId, @PathVariable String followingId){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("followerId", followerId);
		map.put("followingId", followingId);
		
		int result = followService.checkfollow(map);
		return handleSuccess(followerId + " 회원" + followingId + " 회원 팔로잉 여부: " + result + '\n');
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