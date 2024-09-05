package com.rorent.restapi.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rorent.restapi.config.BaseResponse;
import com.rorent.restapi.user.model.TbUserVO;
import com.rorent.restapi.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v1/user")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/getUser")
	public ResponseEntity<?> getUserInfo(@RequestParam Long id){
		return ResponseEntity.ok().body(new BaseResponse<TbUserVO>(userService.findByUserId(id)));
	}

	@GetMapping("/getAllUser")
	public ResponseEntity<?> getUserInfo(){
		return ResponseEntity.ok().body(new BaseResponse<List<TbUserVO>>(userService.findAll()));
	}

	@PostMapping("/insertUser")
	public ResponseEntity<?> insertUser(@RequestBody TbUserVO tbUserVO) {
		userService.insertUser(tbUserVO);
		return ResponseEntity.ok().body(new BaseResponse());
	}

	@PostMapping("/updateUser")
	public ResponseEntity<?> updateUser(@RequestBody TbUserVO tbUserVO) {
		userService.updateUser(tbUserVO);
		return ResponseEntity.ok().body(new BaseResponse());
	}

	@GetMapping("/deleteUser")
	public ResponseEntity<?> updateUser(@RequestParam Long id) {
		userService.deleteById(id);
		return ResponseEntity.ok().body(new BaseResponse());
	}
}
