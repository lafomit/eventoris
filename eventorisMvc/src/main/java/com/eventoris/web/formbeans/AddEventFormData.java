package com.eventoris.web.formbeans;

public class AddEventFormData {

	private String title;
	private String description;
	private int category;
	private String address;
	private String eventdate; 
	private int eventid;
	private int hour = 0;
	private int minutes = 0;
	
	public int getEventid() {
		return eventid;
	}
	public void setEventid(int eventid) {
		this.eventid = eventid;
	}
	public int getCategory() {
		return category;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEventdate() {
		return eventdate;
	}
	public void setEventdate(String eventdate) {
		this.eventdate = eventdate;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getHour() {
		return hour;
	}
	
	public int getMinutes() {
		return minutes;
	}
	
	public void setHour(int hour) {
		this.hour = hour;
	}
	
	public void setMinutes(int minutes){
		this.minutes = minutes;
	}
	
	public String toString(){
		StringBuilder builder = new StringBuilder(this.getClass().getCanonicalName());
    	builder.append("[Title=").append(getTitle());
    	builder.append(";Description=").append(getDescription());
    	builder.append(";EventDate=").append(getEventdate());
    	builder.append(";Address=").append(getAddress());    	
    	builder.append("]");
    	return builder.toString();
	}
}
