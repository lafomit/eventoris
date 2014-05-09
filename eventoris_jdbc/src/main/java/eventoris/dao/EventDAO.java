package eventoris.dao;

import java.util.List;
import javax.sql.DataSource;

import eventoris.datatypes.EventInfo;
import eventoris.datatypes.CategoryInfo;

import java.util.Date;

public interface EventDAO {
	
	public void setDataSource(DataSource dataSource);	
	public void create(EventInfo event);	
	public EventInfo getEvent(int id);	
	public List<EventInfo> getAll();	
	public void delete(int id);
	public void update(EventInfo event);
	
	public List<EventInfo> getLastEventsByDate(int eventsCount);
	public CategoryInfo getCategory(int id);
	
	public List<EventInfo> getTopEvents(int eventsCount);
}
