package eventoris.dao;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import eventoris.datatypes.CategoryInfo;
import eventoris.datatypes.EventInfo;

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
		EventInfo event = null;
		try{
			  event = jdbcTemplateObject.queryForObject(SQL, new Object[]{id}, new EventMapper());
		}catch (IncorrectResultSizeDataAccessException  ex){
			return null;
		}
		
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
	
	public List<EventInfo> getLastEventsByDate(int eventsCount){
		String SQL = "select * from event_info order by date_created desc limit ?";
		
		List<EventInfo> events = jdbcTemplateObject.query(SQL, new Object[]{eventsCount}, new EventMapper());
		
		return events;
	}
	
	public CategoryInfo getCategory(int id){
		String SQL = "select * from event_categories where id_event_categories = ? ";
		
		CategoryInfo category = jdbcTemplateObject.queryForObject(SQL, new Object[]{id}, new CategoryMapper());
		
		return category;
	}
	
	public List<EventInfo> getTopEvents(int eventsCount){
		String SQL = "select * from event_info join "
				   + "(select id_event, count(id_event) as member_count from participants where id_status = 1 group by id_event) as participants "
				   + "on participants.id_event = event_info.id_event_info "
				   + "order by participants.member_count desc limit ?";
		
		List<EventInfo> events = jdbcTemplateObject.query(SQL, new Object[]{eventsCount}, new EventMapper());
		
		return events;		
	}
	
	private boolean checkIfParticipantExists(int idUser, int idEvent){
		String SQL = "select count(*) from participants where id_user = ? and id_event = ?";
		boolean exists = false;
		
		int count = jdbcTemplateObject.queryForInt(SQL, new Object[]{idUser, idEvent});
		
		System.out.println(count);
		
		if(count != 0)
			exists = true;
		
		return exists;
	}
	
	private boolean compareExistingAndRequestedStatus(int idEvent, int idUser, int idParticipationStatus){
		String SQL = "select id_status from participants where id_event = ? and id_user = ?";
		boolean isEqual = false;
		
		int existingStatus = jdbcTemplateObject.queryForInt(SQL, new Object[]{idEvent,idUser});
		
		if(existingStatus == idParticipationStatus){
			isEqual = true;
		}
		return isEqual;
	}
	
	private void changeParticipationStatus(int idEvent, int idUser, int idParticipationStatus){
		String SQL = "update participants set id_status = ? where id_event = ? and id_user = ?";
		
		jdbcTemplateObject.update(SQL, new Object[]{idParticipationStatus, idEvent, idUser});
		
		System.out.println("Succesfully changed status");
	}
	
	private void addParticipant(int idEvent, int idUser, int idParticipationStatus){
		String SQL = "insert into participants (id_event, id_user, id_status, date_subscribed) values (?, ?, ?, ?)";
		Date tempDate = new Date();
		SimpleDateFormat formatedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String today = formatedDate.format(tempDate);
		
		jdbcTemplateObject.update(SQL, new Object[]{idEvent,idUser,idParticipationStatus,today});
	}
	
	public void subscribeToEvent(int idEvent, int idUser, int idParticipationStatus){
		boolean exists = this.checkIfParticipantExists(idUser, idEvent);
		boolean isEqual = false;
		
		if(exists){
			isEqual = this.compareExistingAndRequestedStatus(idEvent, idUser, idParticipationStatus);
			if(isEqual)
				System.out.println("Dvs. deja sunteţi înscris în lista dată");
			else{
				this.changeParticipationStatus(idUser, idEvent, idParticipationStatus);
			}
			
		}
		else
			this.addParticipant(idEvent, idUser, idParticipationStatus);
	}

	public List<CategoryInfo> getAllCategories() {
		String SQL = "select * from event_categories";
		List<CategoryInfo> categories = jdbcTemplateObject.query(SQL, new CategoryMapper());
		return categories;
	}

	public List<EventInfo> getEventsByTitle(String searchText) {
		String SQL = "select * from event_info where title like '%"+searchText+"%'";
		
		List<EventInfo> events = jdbcTemplateObject.query(SQL,  new EventMapper());
		
		return events;
	}
}
