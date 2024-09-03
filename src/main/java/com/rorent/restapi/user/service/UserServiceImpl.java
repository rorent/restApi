package com.rorent.restapi.user.service;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rorent.restapi.user.model.TbUserVO;
import com.rorent.restapi.user.repository.TbUserVORespository;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	TbUserVORespository tbUserVORespository;

	@Override
	public List<TbUserVO> findAll() {
		return tbUserVORespository.findAll();
	}

	@Override
	public TbUserVO findByUserId(Long id) {
		return tbUserVORespository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void save(TbUserVO vo) {
		tbUserVORespository.save(vo);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		tbUserVORespository.deleteById(id);
	}
}
