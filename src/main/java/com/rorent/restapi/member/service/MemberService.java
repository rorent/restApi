package com.rorent.restapi.member.service;

import java.util.List;

import com.rorent.restapi.member.model.Member;

public interface MemberService {

	public List<Member> findAll();
	public Member findByMemberId(Long id);

	public void insertMember(Member vo);

	public void updateMember(Member vo);

	public void deleteById(Long id);

}
