package eventoris.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import eventoris.datatypes.CommentInfo;
import eventoris.datatypes.UserInfo;

public class UserInfoMapper implements RowMapper<UserInfo> {
	public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserInfo userInfo= new UserInfo();
		userInfo.setFamilyName("pupkin");
		userInfo.setName("Morea");
//		comment.setComment(rs.getString("comment"));
//		comment.setCommentId(rs.getInt("id_comments"));
//		comment.setDateAdded(rs.getString("date_created"));
//		comment.setEventId(rs.getInt("id_event"));
//		comment.setPosterId(rs.getInt("id_owner"));
		return userInfo;
	}

}
