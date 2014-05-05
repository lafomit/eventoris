package eventoris.datatypes;

public class EventInfo {
	private int eventID;
	private String title;
	private int categoryID;
	private String description;
	private String dateCreated;
	private String dateOfEvent;
	private String address;
	private String[] requiredItems;
	private int ownerID;
	private int[] participantsID;
	private int[] potentialParticipantsID;
	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder(this.getClass().getCanonicalName());
		builder.append("[Id: ").append(getEventID());
		builder.append(";Id: ").append(getEventID());
    	builder.append(";Title: ").append(getTitle());
    	builder.append(";Category ID: ").append(getCategoryID());
    	builder.append(";Description: ").append(getDescription());
    	builder.append(";Date created: ").append(getDateCreated());
    	builder.append(";Date of event: ").append(getDateOfEvent());
    	builder.append(";Address: ").append(getAddress()).append("]");
    	return builder.toString();
	}
	
	public int getEventID(){
		return eventID;
	}
	
	public String getTitle(){
		return title;
	}
	
	public int getCategoryID(){
		return categoryID;
	}
	
	public String getDescription(){
		return description;
	}
	
	public String getDateCreated(){
		return dateCreated;
	}
	
	public String getDateOfEvent(){
		return dateOfEvent;
	}
	
	public String getAddress(){
		return address;
	}
	
	public String[] getRequiredItems(){
		return requiredItems;
	}
	
	public int getOwnerID(){
		return ownerID;
	}
	
	public int[] getParticipantsID(){
		return participantsID;
	}
	
	public int[] getPotentialParticipantsID(){
		return potentialParticipantsID;
	}
	
	public void setEventID(int eventID){
		this.eventID = eventID;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public void setCategoryID(int categoryID){
		this.categoryID = categoryID;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public void setDateCreated (String dateCreated){
		this.dateCreated = dateCreated;
	}
	
	public void setDateOfEvent(String dateOfEvent){
		this.dateOfEvent = dateOfEvent;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	public void setRequiredItems(String[] requiredItems){
		this.requiredItems = requiredItems;
	}
	
	public void setOwnerID(int ownerID){
		this.ownerID = ownerID;
	}
	
	public void setPartcipantsID(int[] participantsID){
		this.participantsID = participantsID;
	}
	
	public void setPotentialParticipantsID( int[] potentialParticipantsID){
		this.potentialParticipantsID = potentialParticipantsID;
	}
}
