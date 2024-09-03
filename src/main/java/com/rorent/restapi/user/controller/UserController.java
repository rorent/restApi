package com.rorent.restapi.user.controller;

import java.util.Optional;

import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.rorent.restapi.config.BaseResponse;
import com.rorent.restapi.user.enums.UserStat;
import com.rorent.restapi.user.model.TbUserVO;
import com.rorent.restapi.user.repository.TbUserVORespository;
import com.rorent.restapi.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v1/user")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/getUser")
	public ResponseEntity<?> getUserInfo(Long id){
		return ResponseEntity.ok().body(new BaseResponse<TbUserVO>(userService.findByUserId(id)));
	}

	@PostMapping("/insertUser")
	public ResponseEntity<?> insertUser(TbUserVO tbUserVO) {
		tbUserVO.setUserStatCd(UserStat.NORMAL);
		userService.insertUser(tbUserVO);
		return ResponseEntity.ok().body(new BaseResponse());
	}

	@PostMapping("/updateUser")
	public ResponseEntity<?> updateUser(TbUserVO tbUserVO) {
		userService.updateUser(tbUserVO);
		return ResponseEntity.ok().body(new BaseResponse());
	}

	@GetMapping("/deleteUser")
	public ResponseEntity<?> updateUser(Long id) {
		userService.deleteById(id);
		return ResponseEntity.ok().body(new BaseResponse());
	}
}
