package eventoris.dao;
import eventoris.datatypes.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class EventMapper implements RowMapper<EventInfo>{
	public EventInfo mapRow(ResultSet rs, int rowNum) throws SQLException{
		EventInfo event = new EventInfo();
		event.setEventID(rs.getInt("id_event_info"));
		event.setTitle(rs.getString("title"));
		event.setCategoryID(rs.getInt("id_category"));
		event.setDescription(rs.getString("description"));
		event.setDateCreated(rs.getString("date_created")); // Choose method with 2 parameters
		event.setDateOfEvent(rs.getString("date_of_event")); // Same shit 
		event.setAddress(rs.getString("address"));
		// event.setRequiredItems();
		event.setOwnerID(rs.getInt("id_owner"));
		//event.setPartcipantsID();
		//event.setPotentialParticipants();
		
		return event;
	}
}
