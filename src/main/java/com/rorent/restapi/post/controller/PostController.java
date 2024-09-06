package com.rorent.restapi.post.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rorent.restapi.config.model.BaseResponse;
import com.rorent.restapi.post.service.PostService;
import com.rorent.restapi.user.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v1/post")
public class PostController {

	@Autowired
	PostService postService;

	@GetMapping("/getUser")
	public ResponseEntity<?> getUserInfo(@RequestParam Long id){
		return ResponseEntity.ok().body(new BaseResponse<User>(postService.findByUserId(id)));
	}

	@GetMapping("/getAllUser")
	public ResponseEntity<?> getUserInfo(){
		return ResponseEntity.ok().body(new BaseResponse<List<User>>(postService.findAll()));
	}

	@PostMapping("/insertUser")
	public ResponseEntity<?> insertUser(@RequestBody User tbUserVO) {
		postService.insertUser(tbUserVO);
		return ResponseEntity.ok().body(new BaseResponse());
	}

	@PostMapping("/updateUser")
	public ResponseEntity<?> updateUser(@RequestBody User tbUserVO) {
		postService.updateUser(tbUserVO);
		return ResponseEntity.ok().body(new BaseResponse());
	}

	@GetMapping("/deleteUser")
	public ResponseEntity<?> updateUser(@RequestParam Long id) {
		postService.deleteById(id);
		return ResponseEntity.ok().body(new BaseResponse());
	}
}
