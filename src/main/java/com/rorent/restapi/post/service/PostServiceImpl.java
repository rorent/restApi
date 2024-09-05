package com.rorent.restapi.post.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rorent.restapi.exception.SysException;
import com.rorent.restapi.exception.SysErrorCode;
import com.rorent.restapi.user.enums.UserStat;
import com.rorent.restapi.user.model.User;
import com.rorent.restapi.user.repository.UserRespository;

import jakarta.transaction.Transactional;

@Service
public class PostServiceImpl implements PostService {

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
			userRespository.save(vo);
		}else{
			throw new SysException(SysErrorCode.NOT_FOUND_DATA);
		}
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		userRespository.deleteById(id);
	}
}
