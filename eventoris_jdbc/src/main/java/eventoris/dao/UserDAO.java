package eventoris.dao;

import eventoris.datatypes.UserInfo;

public interface UserDAO {

	public void createUser(UserInfo user);
	
	public UserInfo findUser(String userName);
}
