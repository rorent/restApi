package com.rorent.restapi.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rorent.restapi.post.model.Post;

@Repository
public interface PostRespository extends JpaRepository<Post, Long> {
}
