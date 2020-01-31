/*
 * package com.beer.controller;
 * 
 * import java.util.HashMap; import java.util.Map;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.CrossOrigin; import
 * org.springframework.web.bind.annotation.ExceptionHandler; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.PutMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.beer.model.dto.User; import com.beer.model.service.BeerService;
 * import com.beer.model.service.UserService;
 * 
 * import io.swagger.annotations.ApiOperation;
 * 
 * @CrossOrigin(origins = {"*"}, maxAge=6000)
 * 
 * @RestController public class MainController {
 * 
 * @Autowired private UserService userService;
 * 
 * @Autowired private BeerService beerService;
 * 
 * @ExceptionHandler public ResponseEntity<Map<String, Object>>
 * handler(Exception e){ return handleFail(e.getMessage(), HttpStatus.OK); }
 * 
 * // 하늘 --
 * 
 * @GetMapping("/beer")
 * 
 * @ApiOperation("전체  맥주 목록을 조회하는 기능") public ResponseEntity<Map<String,
 * Object>> searchAllBeer(){ return handleSuccess(beerService.searchAll()); }
 * 
 * @GetMapping("/beerId/{beerId}")
 * 
 * @ApiOperation("맥주 검색 기능") public ResponseEntity<Map<String, Object>>
 * search(@PathVariable int beerId){ System.out.println(beerId); return
 * handleSuccess(beerService.search(beerId)); }
 * 
 * @GetMapping("/beerName/{beerName}")
 * 
 * @ApiOperation("맥주 이름으로 검색") public ResponseEntity<Map<String, Object>>
 * searchByName(@PathVariable String beerName){ System.out.println(beerName);
 * return handleSuccess(beerService.searchByName(beerName)); } //----
 * 
 * @GetMapping("/user")
 * 
 * @ApiOperation("전체  user 목록을 조회하는 기능") public ResponseEntity<Map<String,
 * Object>> searchAllUser(){ return handleSuccess(userService.searchAll()); }
 * 
 * @GetMapping("/user/{userId}")
 * 
 * @ApiOperation("id로 user를 조회하는 기능") public ResponseEntity<Map<String, Object>>
 * searchUser(@PathVariable String userId){ System.out.println(userId); return
 * handleSuccess(userService.search(userId)); }
 * 
 * @PostMapping("/user")
 * 
 * @ApiOperation("user 정보 등록") public ResponseEntity<Map<String, Object>>
 * insertUser(@RequestBody User user){ userService.insert(user); return
 * handleSuccess("등록 완료"); }
 * 
 * @PutMapping("/user")
 * 
 * @ApiOperation("user 정보 수정") public ResponseEntity<Map<String, Object>>
 * updateUser(@RequestBody User user){ userService.update(user); return
 * handleSuccess("등록 완료"); }
 * 
 * public ResponseEntity<Map<String, Object>> handleSuccess(Object data){
 * Map<String, Object> resultMap = new HashMap<String, Object>();
 * resultMap.put("state", "ok"); resultMap.put("data", data); return new
 * ResponseEntity<Map<String,Object>>(resultMap, HttpStatus.OK); }
 * 
 * public ResponseEntity<Map<String, Object>> handleFail(Object data, HttpStatus
 * status){ Map<String, Object> resultMap = new HashMap<String, Object>();
 * resultMap.put("state", "fail"); resultMap.put("data", data); return new
 * ResponseEntity<Map<String,Object>>(resultMap, status); } }
 */