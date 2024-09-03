package com.rorent.restapi.user.service;

import java.util.List;

import com.rorent.restapi.user.model.TbUserVO;

public interface UserService {

	public List<TbUserVO> findAll();
	public TbUserVO findByUserId(Long id);

	public void insertUser(TbUserVO vo);

	public void updateUser(TbUserVO vo);

	public void deleteById(Long id);

}
