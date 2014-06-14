package eventoris.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import eventoris.datatypes.CommentInfo;
import eventoris.datatypes.UserInfo;

public class UserInfoMapper implements RowMapper<UserInfo> {
	public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserInfo userInfo= new UserInfo();
		userInfo.setFamilyName(rs.getString("firstName"));
		userInfo.setName(rs.getString("lastname"));
		userInfo.setUserName(rs.getString("username"));
		userInfo.setEmail(rs.getString("email"));
		userInfo.setId(rs.getInt("id_users"));
		userInfo.setBirthday(rs.getString("birthday"));
		return userInfo;
	}

}
