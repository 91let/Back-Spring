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

import com.beer.model.dto.Beer;
import com.beer.model.dto.BeerComment;
import com.beer.model.service.BeerCommentService;
import com.beer.model.service.BeerService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"*"}, maxAge=6000)
@RestController
public class BeerController {
	@Autowired
	private BeerService beerService;

	@Autowired
	private BeerCommentService beerCommentService;
	
	@ExceptionHandler 
	public ResponseEntity<Map<String, Object>> handler(Exception e){
		return handleFail(e.getMessage(), HttpStatus.OK);
	}

	/* Start: beer --------------------------------------- */
	@GetMapping("/beer")
	@ApiOperation("전체  맥주 목록을 조회하는 기능")
	public ResponseEntity<Map<String, Object>> searchAllBeer(){
		return handleSuccess(beerService.searchAll());
	}

	@GetMapping("/beer/id/{beerId}")
	@ApiOperation("맥주 검색 기능")
	public ResponseEntity<Map<String, Object>> search(@PathVariable int beerId){
		System.out.println(beerId);
		return handleSuccess(beerService.search(beerId));
	}

	@GetMapping("/beer/name/{beerName}")
	@ApiOperation("맥주 이름으로 검색")
	public ResponseEntity<Map<String, Object>> searchByName(@PathVariable String beerName){
		System.out.println(beerName);
		return handleSuccess(beerService.searchByName(beerName));
	}

	@GetMapping("/beer/brewer/{brewer}")
	@ApiOperation("맥주 제조업체로 검색")
	public ResponseEntity<Map<String, Object>> searchByBrewer(@PathVariable String brewer){
		System.out.println(brewer);
		return handleSuccess(beerService.searchByBrewer(brewer));
	}

	@GetMapping("/beer/nation/{nation}")
	@ApiOperation("원산지로 검색")
	public ResponseEntity<Map<String, Object>> searchByNation(@PathVariable String nation){
		System.out.println(nation);
		return handleSuccess(beerService.searchByNation(nation));
	}

	@GetMapping("/beer/alcohol/{alcohol}")
	@ApiOperation("맥주 도수로 검색")
	public ResponseEntity<Map<String, Object>> searchByAlcohol(@PathVariable String alcohol){
		System.out.println(alcohol);
		return handleSuccess(beerService.searchByAlcohol(alcohol));
	}

	@GetMapping("/beer/category/{category}")
	@ApiOperation("맥주 종류로 검색")
	public ResponseEntity<Map<String, Object>> searchByCategory(@PathVariable String category){
		System.out.println(category);
		return handleSuccess(beerService.searchByCategory(category));
	}
	
	@PostMapping("/beer/write")
	@ApiOperation("맥주 데이터 저장")
	public ResponseEntity<Map<String, Object>> beerWrite(@RequestBody Beer beer){
		beerService.insert(beer);
		return handleSuccess("맥주 데이터 저장 성공");
	}
	
	@PutMapping("/beer/update")
	@ApiOperation("맥주 데이터 수정")
	public ResponseEntity<Map<String, Object>> beerUpdate(@RequestBody Beer beer){
		beerService.update(beer);
		return handleSuccess("맥주 데이터 수정 성공");
	}
	
	@DeleteMapping("/beer/delete/{beerId}")
	@ApiOperation("맥주 데이터 삭제")
	public ResponseEntity<Map<String, Object>> beerDelete(@PathVariable int beerId){
		beerService.delete(beerId);
		return handleSuccess("맥주 데이터 삭제 성공");
	}
	/* End: beer --------------------------------------- */

	/* Start: beerComment --------------------------------------- */
	@PostMapping("/beerComment/write")
	@ApiOperation("맥주 댓글 추가")
	public ResponseEntity<Map<String, Object>> commentWrite(@RequestBody BeerComment beerComment){
		beerCommentService.insert(beerComment);
		return handleSuccess("맥주 댓글 저장 성공");
	}	
	
	@PutMapping("/beerComment/update")
	@ApiOperation("맥주 댓글 수정")
	public ResponseEntity<Map<String, Object>> commentUpdate(@RequestBody BeerComment beerComment){
		beerCommentService.update(beerComment);
		return handleSuccess("맥주 댓글 수정 성공");
	}	
	@DeleteMapping("/beerComment/delete")
	@ApiOperation("맥주 댓글 삭제")
	public ResponseEntity<Map<String, Object>> commentDelete(@RequestBody BeerComment beerComment){
		beerCommentService.delete(beerComment);
		return handleSuccess("맥주 댓글 삭제 성공");
	}	
	/* End: beerComment --------------------------------------- */
	
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