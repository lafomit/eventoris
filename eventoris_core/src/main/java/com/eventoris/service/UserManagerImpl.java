package com.eventoris.service;

import eventoris.dao.UserDAO;
import eventoris.dao.UserJDBCTemplate;
import eventoris.datatypes.UserInfo;
import eventoris.datatypes.UserInfoWithCredentials;

public class UserManagerImpl implements UserManager{

	
	private UserDAO userDaoProvider;

	public void setDataSource(UserDAO dataSource) {
		userDaoProvider = dataSource;
	}
	
	
	public UserManagerImpl() {
		userDaoProvider = new UserJDBCTemplate();
	}
	
	public void createNewUser(UserInfoWithCredentials userInfo) {
		userDaoProvider.createUser(userInfo);
		
	}

	public UserInfo findUser(String userName) {
		return userDaoProvider.findUser(userName);
	}

}
