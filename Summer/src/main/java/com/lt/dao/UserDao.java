package com.lt.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lt.model.UsersModel;
import com.lt.utils.GenericDAO;

@Repository
@Transactional
public class UserDao extends GenericDAO<UsersModel, Integer> {

}
