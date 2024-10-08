package com.rorent.restapi.user.service;

import java.util.List;

import com.rorent.restapi.user.model.User;

public interface UserService {

	public List<User> findAll();
	public User findByUserId(Long id);

	public void insertUser(User vo);

	public void updateUser(User vo);

	public void deleteById(Long id);

}
