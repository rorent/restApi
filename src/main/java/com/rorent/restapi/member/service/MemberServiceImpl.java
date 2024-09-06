package com.rorent.restapi.member.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rorent.restapi.exception.BizErrorCode;
import com.rorent.restapi.exception.BizException;
import com.rorent.restapi.member.model.Member;
import com.rorent.restapi.member.repository.MemberRepository;

import jakarta.transaction.Transactional;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberRepository memberRespository;

	@Override
	public List<Member> findAll() {
		return memberRespository.findAll();
	}

	@Override
	public Member findByMemberId(Long id) {
		return memberRespository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void insertMember(Member vo) {
		memberRespository.save(vo);
	}

	@Override
	@Transactional
	public void updateMember(Member vo) {
		Optional<Member> optMember = memberRespository.findById(vo.getId());

		if(optMember.isPresent()){
			memberRespository.save(vo);
		}else{
			throw new BizException(BizErrorCode.INVALID_PARAM);
		}
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		memberRespository.deleteById(id);
	}
}
