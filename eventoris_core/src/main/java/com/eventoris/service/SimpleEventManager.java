package com.eventoris.service;

import java.util.List;

import eventoris.dao.EventDAO;
import eventoris.dao.EventJDBCTemplate;
import eventoris.datatypes.EventInfo;

public class SimpleEventManager implements EventManager {

	private EventDAO eventDaoProvider;

	public SimpleEventManager() {
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

}
