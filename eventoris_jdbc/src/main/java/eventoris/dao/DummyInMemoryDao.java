package eventoris.dao;

import java.util.List;

import javax.sql.DataSource;

import eventoris.datatypes.CategoryInfo;
import eventoris.datatypes.EventInfo;

public class DummyInMemoryDao implements EventDAO{

	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		
	}

	public void create(EventInfo event) {
		// TODO Auto-generated method stub
		
	}

	public EventInfo getEvent(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<EventInfo> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
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

}
