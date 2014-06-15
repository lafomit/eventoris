package eventoris.dao;

import java.util.List;

import javax.sql.DataSource;

import eventoris.datatypes.CommentInfo;
import eventoris.datatypes.EventInfo;
import eventoris.datatypes.CategoryInfo;
import eventoris.datatypes.UserInfo;

import java.util.Date;

public interface EventDAO {

	public void setDataSource(DataSource dataSource);

	public void create(EventInfo event);

	public EventInfo getEvent(int id);

	public List<EventInfo> getAll();
	
	public List<EventInfo> getEventsOwnedByUser(int userId);

	public void delete(int id);

	public void update(EventInfo event);

	public List<EventInfo> getLastEventsByDate(int eventsCount);

	public CategoryInfo getCategory(int id);

	public List<CategoryInfo> getAllCategories();

	public List<EventInfo> getTopEvents(int eventsCount);

	public void subscribeToEvent(int idEvent, int idUser,
			int participationStatus);

	public List<EventInfo> getEventsByTitle(String searchText);

	public List<CommentInfo> getCommentsForEvent(int eventId);

	public int getSubscribedUsersCount(int eventId, int status);
	
	public UserInfo getEventOwnerInfo(int eventId);
	
	public List<EventInfo> getEventsUserIsSubscribedTo(int userId, int statusId);
	
	public void setComment(CommentInfo comment);
	
	public void addParticipant(int idEvent, int idUser, int idParticipationStatus);
	
	// public boolean compareExistingAndRequestedStatus(int idEvent, int idUser,
	// int participationStatus);
	// public boolean checkIfParticipantExists(int idUser, int idEvent);

	// check if participant exists, it may need only status change
	// getParticipants(id_event) select all participants where id event = id and
	// id_status = 1
	// getPotentialParticipants(id_event) select all participants where id event
	// = id and id_status = 2
	// participant class (id_participant, firstName, lastName)
	// searchEvent(title)
	// searchUser(firstName, lastName)
	// reportEvent -> requires column Banned
	// addParticipantToEvent (id_user, id_event) with status 1
	// addPossibleParticipant(id_user, id_event) with status 2
	// banUser(id_user)
	// deleteUser(id_User)
	// selectUsersEventsAsAuthor
	// selectUsersSubsribedEvents

	// notifications for user
	// comments on events
	// send invitation by owner
}
