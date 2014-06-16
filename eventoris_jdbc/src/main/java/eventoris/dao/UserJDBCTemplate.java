package eventoris.dao;

import javax.sql.DataSource;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import eventoris.datatypes.UserInfo;
import eventoris.datatypes.UserInfoWithCredentials;

public class UserJDBCTemplate implements UserDAO{

		private DataSource dataSource;
		private JdbcTemplate jdbcTemplateObject;
		
		public void setDataSource(DataSource dataSource){
			this.dataSource = dataSource;
			this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		}
		
		
		public void createUser(UserInfoWithCredentials user) {
 
			String SQL = "insert into users ( username,email,password,enabled) values (?,?,?,0);";
			
			jdbcTemplateObject.update(SQL, user.getEmail(),user.getEmail(),user.getPassword());
			
			String SqlRoles ="insert into user_roles ( username, ROLE,id_user) values (?,'ROLE_USER', (select id_users from users where username=?))";
			
			jdbcTemplateObject.update(SqlRoles, user.getEmail(),user.getEmail());
			
			
			String SqlDetails ="insert into user_details ( id_user) values ( (select id_users from users where username=?))";
			
			jdbcTemplateObject.update(SqlDetails,user.getEmail());
		}


		public UserInfo findUser(String userName) {
			
				String SQL = "select user_details.* ,users.* from users"
						+ "	join user_details on user_details.id_user = users.id_users"
						+ " where users.username = ? ";
				UserInfo userInfo;
				try {
					userInfo = jdbcTemplateObject.queryForObject(SQL,
							new Object[] { userName }, new UserInfoMapper());
				} catch (IncorrectResultSizeDataAccessException ex) {
					return null;
				}
				return userInfo;
		}
		
}
