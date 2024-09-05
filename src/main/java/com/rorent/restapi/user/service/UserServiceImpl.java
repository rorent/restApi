package com.rorent.restapi.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rorent.restapi.exception.BizErrorCode;
import com.rorent.restapi.exception.BizException;
import com.rorent.restapi.user.enums.UserStat;
import com.rorent.restapi.user.model.User;
import com.rorent.restapi.user.repository.UserRespository;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRespository userRespository;

	@Override
	public List<User> findAll() {
		return userRespository.findAll();
	}

	@Override
	public User findByUserId(Long id) {
		return userRespository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void insertUser(User vo) {
		vo.setUserStatCd(UserStat.NORMAL);
		userRespository.save(vo);
	}

	@Override
	@Transactional
	public void updateUser(User vo) {
		Optional<User> optUser = userRespository.findById(vo.getUserId());

		if(optUser.isPresent()){
			User orgData = optUser.get();
			orgData.setUpdateData(vo);
			userRespository.save(orgData);
		}else{
			throw new BizException(BizErrorCode.INVALID_PARAM);
		}
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		userRespository.deleteById(id);
	}
}
