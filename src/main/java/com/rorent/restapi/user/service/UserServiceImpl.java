package com.rorent.restapi.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rorent.restapi.exception.BizErrorCode;
import com.rorent.restapi.exception.BizException;
import com.rorent.restapi.user.enums.UserStat;
import com.rorent.restapi.user.model.User;
import com.rorent.restapi.user.repository.TbUserVORespository;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	TbUserVORespository tbUserVORespository;

	@Override
	public List<User> findAll() {
		return tbUserVORespository.findAll();
	}

	@Override
	public User findByUserId(Long id) {
		return tbUserVORespository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void insertUser(User vo) {
		vo.setUserStatCd(UserStat.NORMAL);
		tbUserVORespository.save(vo);
	}

	@Override
	@Transactional
	public void updateUser(User vo) {
		Optional<User> optUser = tbUserVORespository.findById(vo.getUserId());

		if(optUser.isPresent()){
			User orgData = optUser.get();
			orgData.setUpdateData(vo);
			tbUserVORespository.save(orgData);
		}else{
			throw new BizException(BizErrorCode.INVALID_PARAM);
		}
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		tbUserVORespository.deleteById(id);
	}
}
