package com.rorent.restapi.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rorent.restapi.exception.BizException;
import com.rorent.restapi.exception.ErrorCode;
import com.rorent.restapi.user.enums.UserStat;
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
	public void insertUser(TbUserVO vo) {
		vo.setUserStatCd(UserStat.NORMAL);
		tbUserVORespository.save(vo);
	}

	@Override
	@Transactional
	public void updateUser(TbUserVO vo) {
		Optional<TbUserVO> optUser = tbUserVORespository.findById(vo.getUserId());

		if(optUser.isPresent()){
			tbUserVORespository.save(vo);
		}else{
			throw new BizException(ErrorCode.NOT_FOUND_DATA);
		}
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		tbUserVORespository.deleteById(id);
	}
}
