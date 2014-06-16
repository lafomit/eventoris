package com.eventoris.service;

import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import eventoris.dao.EventDAO;
import eventoris.dao.EventJDBCTemplate;
import eventoris.datatypes.CommentInfo;
import eventoris.datatypes.EventInfo;
import eventoris.datatypes.ParticipantInfo;
import eventoris.datatypes.UserEventStatus;
import eventoris.datatypes.UserInfo;

public class EventManagerImpl implements EventManager {

	private EventDAO eventDaoProvider;
	protected final Log logger = LogFactory.getLog(getClass());
	
	public EventManagerImpl() {
		eventDaoProvider = new EventJDBCTemplate();
	}

	public void setDataSource(EventDAO dataSource) {
		eventDaoProvider = dataSource;
	}

	public List<EventInfo> getAllEventsCreatedByUser(int userId) {
		return eventDaoProvider.getEventsOwnedByUser(userId);
	}

	public List<EventInfo> getAllEvents() {
		return eventDaoProvider.getAll();
	}

	public void createNewEventInfo(EventInfo event) {
		eventDaoProvider.create(event);
	}

	public List<EventInfo> getLastEventsByDate(int eventsCount) {
		return eventDaoProvider.getLastEventsByDate(eventsCount);
	}

	public List<EventInfo> getTopEvents(int eventsCount) {
		return eventDaoProvider.getTopEvents(eventsCount);
	}

	public EventInfo getEventById(int id) {
		return eventDaoProvider.getEvent(id);
	}

	public List<EventInfo> getEventByTitle(String searchText) {
		return eventDaoProvider.getEventsByTitle(searchText);
	}

	public List<CommentInfo> getCommentsForEvent(int eventId) {
		return eventDaoProvider.getCommentsForEvent(eventId);
	}

	public int getNumberOfComingParticipants(int eventId) {
		return eventDaoProvider.getSubscribedUsersCount(eventId, 1);
	}

	public int getNumberOfTotalParticipants(int eventId) {
		int subscribed = eventDaoProvider.getSubscribedUsersCount(eventId, 1);
		int maybe = eventDaoProvider.getSubscribedUsersCount(eventId, 2);
		return subscribed + maybe;
	}

	public int getNumberOfMaybeGoingParticipants(int eventId) {
		return eventDaoProvider.getSubscribedUsersCount(eventId, 2);
	}

	public UserInfo getOnwerOfTheEvent(int eventId) {
		return eventDaoProvider.getEventOwnerInfo(eventId);
	}

	public List<EventInfo> getAllEventsUserIsGoing(int userId) {
		return eventDaoProvider.getEventsUserIsSubscribedTo(userId, 1);
	}

	public List<EventInfo> getAllEventsUserMaybeComes(int userId) {
		return eventDaoProvider.getEventsUserIsSubscribedTo(userId, 2);
	}

	public void updateEvent(EventInfo eventInfo) {
		eventDaoProvider.update(eventInfo);

	}

	public void addComment(CommentInfo comment) {
		eventDaoProvider.setComment(comment);
	}

	public void participate(ParticipantInfo participant) {

		boolean exists = eventDaoProvider.checkIfParticipantExists(participant);
		boolean isEqual = false;

		logger.info("EventManagerImpl.participate: exists=" + exists);
		if (exists) {
			isEqual = eventDaoProvider
					.compareExistingAndRequestedStatus(participant);
			logger.info("EventManagerImpl.participate: isEqual=" + isEqual);
			if (!isEqual) {
				logger.info("EventManagerImpl.participate: changing status");
				eventDaoProvider.changeParticipationStatus(participant);
			}

		} else{
			logger.info("EventManagerImpl.participate: adding participant");
			eventDaoProvider.addParticipant(participant);
		}
	}

	public List<EventInfo> getEventsByCategory(int idCategory) {
		return eventDaoProvider.getEventsByCategory(idCategory);
	}
	
	public void deleteEvent(int idEvent){
		eventDaoProvider.delete(idEvent);
	}

	public UserEventStatus getUserEventStatus(int eventId, int userId) {
		return eventDaoProvider.getEventStatusForEvent(eventId, userId);
	}

	public List<UserInfo> getTop3ComingUsers(int eventId) {
		return eventDaoProvider.getTopParticipatingUsers(eventId, 1, 3);
	}

	public List<UserInfo> getTop3MaybeComingUsers(int eventId) {
		return eventDaoProvider.getTopParticipatingUsers(eventId, 2, 3);
	}

}
