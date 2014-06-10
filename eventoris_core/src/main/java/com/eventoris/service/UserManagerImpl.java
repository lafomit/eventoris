package com.eventoris.service;

import eventoris.dao.EventDAO;
import eventoris.dao.EventJDBCTemplate;
import eventoris.dao.UserDAO;
import eventoris.dao.UserJDBCTemplate;
import eventoris.datatypes.UserInfo;

public class UserManagerImpl implements UserManager{

	
	private UserDAO userDaoProvider;

	public void setDataSource(UserDAO dataSource) {
		userDaoProvider = dataSource;
	}
	
	
	public UserManagerImpl() {
		userDaoProvider = new UserJDBCTemplate();
	}
	
	public void createNewUser(UserInfo userInfo) {
		userDaoProvider.createUser(userInfo);
		
	}

}
