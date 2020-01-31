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

import com.beer.model.dto.Star;
import com.beer.model.service.StarService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"*"}, maxAge=6000)
@RestController
public class StarController {
	
	@Autowired
	private StarService starService;
	
	@ExceptionHandler 
	public ResponseEntity<Map<String, Object>> handler(Exception e){
		return handleFail(e.getMessage(), HttpStatus.OK);
	}
	
	@GetMapping("/star")
	@ApiOperation("모든 평점")
	public ResponseEntity<Map<String, Object>> searchAll(){
		return handleSuccess(starService.searchall());
	}
	
	@GetMapping({"/star/search/{beerId}/{userId}"})
	@ApiOperation("평점 여부 확인")
	public ResponseEntity<Map<String, Object>> searchStar(@PathVariable int beerId, @PathVariable String userId){
		return handleSuccess(starService.search(star));
	}
	
	@GetMapping("/star/user/{userId}")
	@ApiOperation("유저당 평점 정보")
	public ResponseEntity<Map<String, Object>> searchStarByUser(@PathVariable String userId){
		return handleSuccess(starService.searchByUser(userId));
	}
	
	@GetMapping("/star/usercount/{userId}")
	@ApiOperation("유저당 평점 매긴 개수")
	public ResponseEntity<Map<String, Object>> countByUser(@PathVariable String userId){
		return handleSuccess(starService.countByUser(userId));
	}
	
	@GetMapping("/star/countbeer/{beerId}")
	@ApiOperation("맥주당 평점 개수")
	public ResponseEntity<Map<String, Object>> countByBeer(@PathVariable int beerId) {
		return handleSuccess(starService.countByBeer(beerId));
	}
	
	@GetMapping("/star/searchbeer/{beerId}")
	@ApiOperation("평점을 남긴 유저")
	public ResponseEntity<Map<String, Object>> searchByBeer(@PathVariable int beerId) {
		return handleSuccess(starService.searchByBeer(beerId));
	}
	
	@PostMapping("/star/same")
	@ApiOperation("같은 평점을 남긴 사람")
	public ResponseEntity<Map<String, Object>> samestar(@RequestBody Star star) {
		return handleSuccess(starService.samestar(star));
	}
	
	@PostMapping("/star/samecount")
	@ApiOperation("같은 평점을 남긴 유저 수")
	public ResponseEntity<Map<String, Object>> countsamestar(@RequestBody Star star) {
		return handleSuccess(starService.countsamestar(star));
	}
	
	@PostMapping("/star")
	@ApiOperation("평점 정보 등록")
	public ResponseEntity<Map<String, Object>> insertStar(@RequestBody Star star){
		starService.insert(star);
		return handleSuccess("등록 완료");
	}

	@PutMapping("/star")
	@ApiOperation("평점 정보 수정")
	public ResponseEntity<Map<String, Object>> updateStar(@RequestBody Star star){
		starService.update(star);
		return handleSuccess("수정 완료");
	}
	
	@GetMapping("/star/beer/{beerId}")
	@ApiOperation("맥주당 별점 평균")
	public ResponseEntity<Map<String, Object>> avgStar(@PathVariable int beerId) {
		return handleSuccess(starService.AVGScore(beerId));
	}
	
	 @DeleteMapping("/star")
	 @ApiOperation("star 정보 삭제 ")
	 public ResponseEntity<Map<String, Object>> deleteStar(@RequestBody Star star) {
		 starService.deletestar(star);
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