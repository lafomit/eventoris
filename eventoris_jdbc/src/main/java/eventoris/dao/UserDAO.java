package eventoris.dao;

import eventoris.datatypes.UserInfo;
import eventoris.datatypes.UserInfoWithCredentials;

public interface UserDAO {

	public void createUser(UserInfoWithCredentials user);
	
	public UserInfo findUser(String userName);
}
