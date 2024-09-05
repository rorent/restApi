package com.rorent.restapi.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rorent.restapi.user.model.User;

public interface TbPostVORespository extends JpaRepository<User, Long> {
}
