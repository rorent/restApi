package com.rorent.restapi.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rorent.restapi.user.model.User;

@Repository
public interface UserRespository extends JpaRepository<User, Long> {
}
