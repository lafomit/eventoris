package com.eventoris.service;

import eventoris.datatypes.UserInfo;

public interface UserManager {
	
	public void createNewUser(UserInfo userInfo);

	public UserInfo findUser(String userName);
}
