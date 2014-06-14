package com.eventoris.service;

import java.util.List;

import eventoris.datatypes.*;

public interface EventManager {

	public List<EventInfo> getAllEventsCreatedByUser(int userId);
	
	public List<EventInfo> getAllEventsUserIsGoing(int userId);
	
	public List<EventInfo> getAllEventsUserMaybeComes(int userId);
	
	
	public void createNewEventInfo(EventInfo event);
	
	public List<EventInfo> getLastEventsByDate(int eventsCount);
	
	public List<EventInfo> getTopEvents(int eventsCount);
	
	public EventInfo getEventById(int id);
	
	public List<EventInfo> getEventByTitle(String searchText);
	
	public List<CommentInfo> getCommentsForEvent(int eventId);
	
	public int getNumberOfComingParticipants(int eventId);
	
	public int getNumberOfTotalParticipants(int eventId);
	
	public int getNumberOfMaybeGoingParticipants(int eventId);
	
	public UserInfo getOnwerOfTheEvent(int eventId);
	
	public List<EventInfo> getAllEvents();
	
	public void updateEvent(EventInfo eventInfo);
}
