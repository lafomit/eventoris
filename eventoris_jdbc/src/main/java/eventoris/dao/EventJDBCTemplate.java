package eventoris.dao;
import eventoris.datatypes.*;

import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class EventJDBCTemplate implements EventDAO{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public void create(EventInfo event){
		String SQL = "insert into event_info (title, id_category, description, date_created, date_of_event, address, id_owner) values (?, ?, ?, ?, ?, ?, ?)";
		
		jdbcTemplateObject.update(SQL, event.getTitle(), 
									   event.getCategoryID(), 
									   event.getDescription(), 
									   event.getDateCreated(), 
									   event.getDateOfEvent(), 
									   event.getAddress(), 
									   event.getOwnerID());
		System.out.println("Created record: \nTitle: " + event.getTitle() + 
											"\nCategID: " + event.getCategoryID() + 
											"\ndescription: " + event.getDescription() + 
											"\ndateCreated: "+ event.getDateCreated() +
											"\ndateOfEvent: "+ event.getDateOfEvent() + 
											"\naddress: " + event.getAddress() + 
											"\nauthorID: " + event.getOwnerID());
		return;
	}
	
	public EventInfo getEvent(int id){ // Aici tot un obiect intreg pentru id?
		String SQL = "select * from event_info where id_event_info = ?";
		EventInfo event = jdbcTemplateObject.queryForObject(SQL, new Object[]{id}, new EventMapper());
		
		return event;
	}
	
	public List<EventInfo> getAll(){
		String SQL = "select * from event_info";
		List<EventInfo> events = jdbcTemplateObject.query(SQL, new EventMapper());
		
		return events;
	}
	
	public void delete(int id){
		String SQL = "delete from event_info where id_event_info = ?";
		
		jdbcTemplateObject.update(SQL, id);
		System.out.println("Deleted event, id = " + id);
		
		return;
	}
	
	public void update (EventInfo event){
		String SQL = "update event_info set title = ?, " +
										   "id_category = ?, " +
										   "description = ?, " +
										   "date_created = ?,  " + 
										   "date_of_event = ?, " +
										   "address = ?, " + 
										   "id_owner = ? " +
										   "where id_event_info = ?";
		
		jdbcTemplateObject.update(SQL, event.getTitle(), 
				   					   event.getCategoryID(), 
				   					   event.getDescription(), 
				   					   event.getDateCreated(), 
				   					   event.getDateOfEvent(), 
				   					   event.getAddress(), 
				   					   event.getOwnerID(),
				   					   event.getEventID());
		System.out.println("Updated!");
		return;
	}
	
	// get participants where id and status
}
