package com.lt.services;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.dao.UserDao;
import com.lt.model.UsersModel;

@Service
public class UsersService implements Serializable {
	private static final long serialVersionUID = 9115447838217865195L;
	@Autowired
	private UserDao userDao;
	public UsersModel findById(Integer id) {
		return userDao.findById(id);
	}
}
