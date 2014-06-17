package eventoris.dao;

import java.util.List;

import javax.sql.DataSource;

import eventoris.datatypes.CommentInfo;
import eventoris.datatypes.EventInfo;
import eventoris.datatypes.CategoryInfo;
import eventoris.datatypes.ParticipantInfo;
import eventoris.datatypes.UserEventStatus;
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
	
	public void addParticipant(ParticipantInfo participant);
	
	public boolean checkIfParticipantExists(ParticipantInfo participant);
	
	public boolean compareExistingAndRequestedStatus(ParticipantInfo participant);
	
	public void changeParticipationStatus(ParticipantInfo participant);
	
	public List<EventInfo> getEventsByCategory(int idCategory);
	
	public UserEventStatus getEventStatusForEvent(int eventId, int userId);
	
	public List<UserInfo> getTopParticipatingUsers(int eventId, int status, int resultCount);
	
	public void removeParticipant(ParticipantInfo participant);
}
