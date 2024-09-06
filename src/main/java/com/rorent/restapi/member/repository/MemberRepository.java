package com.rorent.restapi.member.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rorent.restapi.member.model.Member;

public interface MemberRepository extends MongoRepository<Member, Long> {
}
