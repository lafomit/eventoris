package com.eventoris.service;

import java.util.List;

import eventoris.dao.EventDAO;
import eventoris.dao.EventJDBCTemplate;
import eventoris.datatypes.EventInfo;

public class  EventManagerImpl implements EventManager {

	private EventDAO eventDaoProvider;

	public EventManagerImpl() {
		eventDaoProvider = new EventJDBCTemplate();
	}

	public void setDataSource(EventDAO dataSource) {
		eventDaoProvider = dataSource;
	}

	public List<EventInfo> getAllEventsForUser() {
	    return eventDaoProvider.getAll();

	}

	public void createNewEventInfo(EventInfo event) {
		// TODO Auto-generated method stub
		eventDaoProvider.create(event);
	}
	
	public List<EventInfo> getLastEventsByDate(int eventsCount){
		return eventDaoProvider.getLastEventsByDate(eventsCount);
	}
	
	public List<EventInfo> getTopEvents(int eventsCount){
		return eventDaoProvider.getTopEvents(eventsCount);
	}
	
	public EventInfo getEventById(int id){
		return eventDaoProvider.getEvent(id);
	}
/*	
	public String getDay(List<EventInfo> events){
		
		String[] days; 
		
		for(int i = 1; i < events.size(); i++)
		= date.substring(0, 4);
		
		return day;
	}
	*/
}
