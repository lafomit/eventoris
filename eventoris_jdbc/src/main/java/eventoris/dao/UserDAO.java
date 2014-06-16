package eventoris.dao;

import java.util.List;

import eventoris.datatypes.UserInfo;
import eventoris.datatypes.UserInfoWithCredentials;

public interface UserDAO {

	public void createUser(UserInfoWithCredentials user);
	
	public UserInfo findUser(String userName);
	
	public String getSubscriberPassword(String userId);
	
	public List<String> getUserRoles(String userId);
}
