package com.eventoris.service;

import java.util.List;

import eventoris.datatypes.*;

public interface EventManager {

	public List<EventInfo> getAllEventsForUser();
	
	public void createNewEventInfo(EventInfo event);
	
	public List<EventInfo> getLastEventsByDate(int eventsCount);
	
	public List<EventInfo> getTopEvents(int eventsCount);
	
	public EventInfo getEventById(int id);
	
	/*public String getDay(String date);*/
}
