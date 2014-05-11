package com.eventoris.service;

import java.util.List;

import eventoris.datatypes.*;

public interface EventManager {

	public List<EventInfo> getAllEventsForUser();
	
	public void createNewEventInfo(EventInfo event);
}
