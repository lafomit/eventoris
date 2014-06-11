package eventoris.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import eventoris.datatypes.CommentInfo;

public class CommentMapper implements RowMapper<CommentInfo> {
	public CommentInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		CommentInfo comment = new CommentInfo();
		comment.setComment(rs.getString("comment"));
		comment.setCommentId(rs.getInt("id_comments"));
		comment.setDateAdded(rs.getString("date_created"));
		comment.setEventId(rs.getInt("id_event"));
		comment.setPosterId(rs.getInt("id_owner"));
		return comment;
	}

}
