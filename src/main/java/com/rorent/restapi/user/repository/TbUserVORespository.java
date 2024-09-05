package com.rorent.restapi.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rorent.restapi.user.model.User;

public interface TbUserVORespository extends JpaRepository<User, Long> {
}
