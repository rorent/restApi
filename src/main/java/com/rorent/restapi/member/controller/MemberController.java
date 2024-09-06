package com.rorent.restapi.member.controller;

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
import com.rorent.restapi.member.model.Member;
import com.rorent.restapi.member.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v1/member")
public class MemberController {

	@Autowired
	MemberService memberService;

	@GetMapping("/getMember")
	public ResponseEntity<?> getMemberInfo(@RequestParam Long id){
		return ResponseEntity.ok().body(new BaseResponse<Member>(memberService.findByMemberId(id)));
	}

	@GetMapping("/getAllMember")
	public ResponseEntity<?> getMemberInfo(){
		return ResponseEntity.ok().body(new BaseResponse<List<Member>>(memberService.findAll()));
	}

	@PostMapping("/insertMember")
	public ResponseEntity<?> insertMember(@RequestBody Member member) {
		memberService.insertMember(member);
		return ResponseEntity.ok().body(new BaseResponse());
	}

	@PostMapping("/updateMember")
	public ResponseEntity<?> updateMember(@RequestBody Member member){
		memberService.updateMember(member);
		return ResponseEntity.ok().body(new BaseResponse());
	}

	@GetMapping("/deleteMember")
	public ResponseEntity<?> deleteMember(@RequestParam Long id) {
		memberService.deleteById(id);
		return ResponseEntity.ok().body(new BaseResponse());
	}
}
