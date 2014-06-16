package com.eventoris.service;

import eventoris.datatypes.UserInfo;
import eventoris.datatypes.UserInfoWithCredentials;

public interface UserManager {
	
	public void createNewUser(UserInfoWithCredentials userInfo);

	public UserInfo findUser(String userName);
}
