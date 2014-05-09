package eventoris.dao;
import eventoris.datatypes.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CategoryMapper implements RowMapper<CategoryInfo>{
	public CategoryInfo mapRow(ResultSet rs, int rowNum) throws SQLException{
		CategoryInfo category = new CategoryInfo();
		
		category.setIdCategory(rs.getInt("id_event_categories"));
		category.setCategoryName(rs.getString("category_name"));
		category.setCategoryDescription(rs.getString("category_description"));
		
		return category;		
	}

}
