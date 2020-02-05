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
import com.beer.model.dto.BeerLike;
import com.beer.model.service.BeerCommentService;
import com.beer.model.service.BeerLikeService;
import com.beer.model.service.BeerService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"*"}, maxAge=6000)
@RestController
public class BeerController {
	@Autowired
	private BeerService beerService;

	@Autowired
	private BeerCommentService beerCommentService;
	
	@Autowired
	private BeerLikeService beerLikeService;
	
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
		boolean result = beerService.insert(beer);
		if(result) return handleSuccess(beer.getBeerName() + " 맥주 데이터 저장\n");
		else return handleFail("등록 실패", HttpStatus.UNAUTHORIZED);
	}
	
	@PutMapping("/beer/update")
	@ApiOperation("맥주 데이터 수정")
	public ResponseEntity<Map<String, Object>> beerUpdate(@RequestBody Beer beer){
		boolean result = beerService.update(beer);
		if(result) return handleSuccess(beer.getBeerName() + " 맥주 데이터 수정\n");
		else return handleFail("등록 실패", HttpStatus.UNAUTHORIZED);
	}
	
	@DeleteMapping("/beer/delete/{beerId}")
	@ApiOperation("맥주 데이터 삭제")
	public ResponseEntity<Map<String, Object>> beerDelete(@PathVariable int beerId){
		boolean result = beerService.delete(beerId);
		if(result) return handleSuccess(beerId + "번 맥주 데이터 삭제\n");
		else return handleFail("등록 실패", HttpStatus.UNAUTHORIZED);
	}
	/* End: beer --------------------------------------- */

	/* Start: beerComment --------------------------------------- */
	@GetMapping("/beer/Comment")
	@ApiOperation("맥주 댓글 보기")
	public ResponseEntity<Map<String, Object>> commentList(){
		return handleSuccess(beerCommentService.searchAll());
	}	
	
	@PostMapping("/beer/Comment/write")
	@ApiOperation("맥주 댓글 추가")
	public ResponseEntity<Map<String, Object>> commentWrite(@RequestBody BeerComment beerComment){
		boolean result = beerCommentService.insert(beerComment);
		if(result) return handleSuccess(beerComment.getBeerId() + "번 맥주 댓글 저장\n");
		else return handleFail("등록 실패", HttpStatus.UNAUTHORIZED);
	}
	
	@PutMapping("/beer/Comment/update")
	@ApiOperation("맥주 댓글 수정")
	public ResponseEntity<Map<String, Object>> commentUpdate(@RequestBody BeerComment beerComment){
		boolean result = beerCommentService.update(beerComment);
		if(result) return handleSuccess(beerComment.getBeerId() + "번 맥주 댓글 수정\n");
		else return handleFail("수정 실패", HttpStatus.UNAUTHORIZED);
	}	

	@DeleteMapping("/beer/Comment/delete/{commentId}")
	@ApiOperation("맥주 댓글 삭제")
	public ResponseEntity<Map<String, Object>> commentDelete(@PathVariable int commentId){
		boolean result = beerCommentService.delete(commentId);
		if(result) return handleSuccess(commentId + "번 댓글 삭제\n");
		else return handleFail("삭제 실패", HttpStatus.UNAUTHORIZED);
	}	
	
	@GetMapping("/beer/Comment/count/{beerId}")
	@ApiOperation("맥주별 댓글 카운트")
	public ResponseEntity<Map<String, Object>> commentCount(@PathVariable int beerId){
		int cnt = beerCommentService.count(beerId);
		return handleSuccess("맥주별 댓글 카운트: " + cnt + "\n");
	}
	/* End: beerComment --------------------------------------- */
	
	/* Start: beerLike --------------------------------------- */
	@GetMapping("/beer/like/count/{userId}/{beerId}")
	@ApiOperation("회원별 맥주 찜 여부 확인 1: O, 0: X")
	public ResponseEntity<Map<String, Object>> searchLike(@PathVariable String userId, @PathVariable int beerId){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("beerId", Integer.toString(beerId));
		
		int result = beerLikeService.search(map);
		return handleSuccess(userId + " 회원 맥주 찜 여부: " + result + "\n");
	}

	@PostMapping("/beer/like/write")
	@ApiOperation("회원 맥주 찜 저장")
	public ResponseEntity<Map<String, Object>> writeLike(@RequestBody BeerLike beerLike){
		boolean result = beerLikeService.insert(beerLike);
		if(result) return handleSuccess(beerLike.getUserId() + " 회원" + beerLike.getBeerId() + " 맥주 찜 저장");
		else return handleFail("등록 실패", HttpStatus.UNAUTHORIZED);
	}
	
	@DeleteMapping("/beer/like/delete")
	@ApiOperation("회원 맥주 찜 삭제")
	public ResponseEntity<Map<String, Object>> deleteLike(@RequestBody BeerLike beerLike){
		boolean result = beerLikeService.delete(beerLike);
		if(result) return handleSuccess(beerLike.getUserId() + " 회원" + beerLike.getBeerId() + " 맥주 찜 삭제");
		else return handleFail("삭제 실패", HttpStatus.UNAUTHORIZED);
	}
	
	@GetMapping("beer/like/count/{beerId}")
	@ApiOperation("해당 맥주 찜 개수")
	public ResponseEntity<Map<String, Object>> countLike(@PathVariable int beerId){
		int result = beerLikeService.countLike(beerId);
		return handleSuccess(beerId + " 맥주 찜 개수: " + result);
	}
	/* End: beerLike --------------------------------------- */
	
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