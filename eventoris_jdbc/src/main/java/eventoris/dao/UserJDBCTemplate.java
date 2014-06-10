package eventoris.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import eventoris.datatypes.EventInfo;
import eventoris.datatypes.UserInfo;

public class UserJDBCTemplate implements UserDAO{

		private DataSource dataSource;
		private JdbcTemplate jdbcTemplateObject;
		
		public void setDataSource(DataSource dataSource){
			this.dataSource = dataSource;
			this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		}
		
		
		public void createUser(UserInfo user) {
//				String SQL = "insert into users ( id_users,email,password_hash,password_salt,active,admin,banner,reset_key,reset_expires) " +
//						"values ((select max(id_users )+1 from users),'%s','3ca4297f082595c480871657e1a7091b','3456',1,0,0,null,null);";
//				
//				jdbcTemplateObject.execute(String.format(SQL,  
//											   user.getEmail()));
			user.setId(getMaxUserId());
			String SQL = "insert into users ( id_users,email,password_hash,password_salt,active,admin,banner,reset_key,reset_expires) " +
					"values (?,?,'3ca4297f082595c480871657e1a7091b','3456',1,0,0,null,null);";
			
			jdbcTemplateObject.update(SQL,  user.getId(),
										   user.getEmail());
		}
		
		
		private int getMaxUserId(){
			return 800;
		}
		
}
