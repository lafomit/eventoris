package com.eventoris.service;

import java.util.List;

import eventoris.datatypes.UserInfo;
import eventoris.datatypes.UserInfoWithCredentials;

public interface UserManager {
	
	public void createNewUser(UserInfoWithCredentials userInfo);

	public UserInfo findUser(String userName);
	
	public String getSubscriberPassword(String userId);
	
	public List<String> getUserRoles(String userId);
}
