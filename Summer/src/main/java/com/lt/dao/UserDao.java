package com.lt.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lt.model.UsersModel;
import com.lt.utils.GenericDAO;

@Repository
@Transactional
public class UserDao extends GenericDAO<UsersModel, Integer> implements Serializable {
	private static final long serialVersionUID = 6883219323221961698L;

}
