package com.rorent.restapi.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rorent.restapi.user.model.TbUserVO;

public interface TbUserVORespository extends JpaRepository<TbUserVO, Long> {
}
