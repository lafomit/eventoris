package eventoris.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import eventoris.datatypes.CategoryInfo;
import eventoris.datatypes.CommentInfo;
import eventoris.datatypes.EventInfo;
import eventoris.datatypes.UserInfo;

public class DummyInMemoryDao implements EventDAO{

	/*
		EventInfo event = new EventInfo();
		event.setTitle("some title");
		List<EventInfo> result = new ArrayList<EventInfo>();
		result.add(event);
		return result;
	 */
	
	private static List<EventInfo> eventInfoDB = new ArrayList<EventInfo>();
	
	
	private EventInfo createDummyEventInfo(int seedId){
		EventInfo result = new EventInfo();
		result.setDescription("Some event description " + seedId );
		result.setTitle("EventIntersting Title" + seedId );
		result.setDateCreated("dummy date" + seedId);
		result.setOwnerID(2);
		return result;
	}
	public DummyInMemoryDao(){
		for(int i=0;i<10;i++){
			eventInfoDB.add(createDummyEventInfo(eventInfoDB.size()));
		}
	}
	
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		
	}

	public void create(EventInfo event) {
		eventInfoDB.add(event);
	}

	public EventInfo getEvent(int id) {
		if(id < eventInfoDB.size())
			return eventInfoDB.get(id);
		else 
			return null;
	}

	public List<EventInfo> getAll() {
		return eventInfoDB;
	}

	public void delete(int id) {
		if(id < eventInfoDB.size())
			eventInfoDB.remove(id);
	}

	public void update(EventInfo event) {
		// TODO Auto-generated method stub
		
	}

	public List<EventInfo> getLastEventsByDate(int eventsCount) {
		// TODO Auto-generated method stub
		return null;
	}

	public CategoryInfo getCategory(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<EventInfo> getTopEvents(int eventsCount) {
		// TODO Auto-generated method stub
		return null;
	}

	public void subscribeToEvent(int idEvent, int idUser,
			int participationStatus) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	public List<CategoryInfo> getAllCategories() {
		List<CategoryInfo> category = new ArrayList<CategoryInfo>();
		CategoryInfo cat1= new CategoryInfo();cat1.setCategoryName("Sports"); cat1.setCategoryDescription("Sport Event"); cat1.setIdCategory(1);
		category.add(cat1);
		cat1= new CategoryInfo();cat1.setCategoryName("Social"); cat1.setCategoryDescription("Social Event"); cat1.setIdCategory(2);
		category.add(cat1);
		cat1= new CategoryInfo();cat1.setCategoryName("Wurst events"); cat1.setCategoryDescription("Religious Events against Concita"); cat1.setIdCategory(3);
		category.add(cat1);
		
		return category;
	}
	public List<EventInfo> getEventsByTitle(String searchText) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<CommentInfo> getCommentsForEvent(int eventId) {
		// TODO Auto-generated method stub
		return null;
	}
	public int getSubscribedUsersCount(int eventId, int status) {
		// TODO Auto-generated method stub
		return 0;
	}
	public UserInfo getEventOwnerInfo(int eventId) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<EventInfo> getEventsOwnedByUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
